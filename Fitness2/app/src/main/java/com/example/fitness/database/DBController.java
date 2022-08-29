package com.example.fitness.database;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DBController {

    private static String URL_GLOBAL_DB = "http://10.21.80.233/CJ/";

    private static boolean checkNetworkConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && info.isConnected());
    }


    //Métodos
    public static int insertUsuarios(Context context,  String email, String nome, String senha, String telefone) throws IOException {

        if (!checkNetworkConnection(context)) {
            return 0;
        }
        checkThreadPolicy();
        String values = "email="+email+"&"+"nome="+nome+"&"+"senha="+senha+"&"+"telefone="+telefone;
        URL url = new URL(URL_GLOBAL_DB + "ws_insert_usuarios.php?"+values);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response = bufferedReader.readLine();

        if (response.equals("false")) {
            Toast.makeText(context, "Erro no BD Global!", Toast.LENGTH_LONG).show();
            return 0;
        } else {
            return 1;
        }
    }

    public static int insertGrupos(Context context,  String nome, String data, String horainicio, String horafinal,
                                   String custo, String nivel, String localizacao, String descricao,
                                   String modalidade_nome, String usuario_email) throws IOException {

        if (!checkNetworkConnection(context)) {
            return 0;        }
        checkThreadPolicy();
        String values = "nome="+nome+"&"+"data="+data+"&"+"horainicio="+horainicio+"&"+"horafinal="+horafinal+
        "&"+"custo="+custo+"&"+"nivel="+nivel+"&"+"localizacao="+localizacao+"&"+"descricao="+descricao+
                "&"+"modalidade_nome="+modalidade_nome+"&"+"usuario_email="+usuario_email;
        URL url = new URL(URL_GLOBAL_DB + "ws_insert_grupo.php?"+values);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String response = bufferedReader.readLine();

        if (response.equals("false")) {
            Toast.makeText(context, "Erro no BD Global!", Toast.LENGTH_LONG).show();
            return 0;
        } else {
            return 1;
        }
    }

    public JSONArray selectUsuario(Context context) throws JSONException, IOException {
        if (!checkNetworkConnection(context)) {
            return null;
        }
        checkThreadPolicy();
        URL url = new URL(URL_GLOBAL_DB + "ws_select_usuario.php");//aqui coloca o nome do arquivo php
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String json;
        while ((json = bufferedReader.readLine()) != null) {
            sb.append(json + "\n");
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;

    }

    public static JSONArray selectAllGrupo(Context context) throws JSONException, IOException {
        if (!checkNetworkConnection(context)) {
            return null;
        }
        checkThreadPolicy();
        URL url = new URL(URL_GLOBAL_DB + "ws_select_grupo.php");//aqui coloca o nome do arquivo php
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String json;
        while ((json = bufferedReader.readLine()) != null) {
            sb.append(json + "\n");
        }
        JSONArray jsonArray = new JSONArray(sb.toString().trim());
        return jsonArray;

    }
    private static void checkThreadPolicy(){
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}

