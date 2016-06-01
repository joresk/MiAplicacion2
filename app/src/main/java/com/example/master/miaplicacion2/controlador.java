package com.example.master.miaplicacion2;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Master on 09/05/2016.
 */
public class controlador {

    static String cadena = "";
    static int ban = 0;
    static boolean hombre=false;
    static boolean mujer=false;
    static boolean nino=false;

    static boolean desempleado=false;
    static boolean dependiente=false;
    static boolean desatentido=false;
    static boolean indicioPSY1=false;
    static boolean aislado=false;
    static boolean controlado=false;
    static boolean indicioPSY2=false;
    static boolean conflicto=false;
    static boolean discriminada=false;
    static boolean amenazado=false;
    static boolean golpeado=false;
    static boolean vioPatrimonial=false;


    public static void interaccion(TextView lblPregunta,String c) {


        switch(ban){
            case 0:
                if(c.equals("si")){
                    ban = 1;
                    lblPregunta.setText("¿Actualmente estás trabajando o estudiando?");
                }
                else {

                }
                break;

            case 1:
                if(c.equals("no")){
                    desempleado=true;
                    ban = 2;
                    lblPregunta.setText("¿Te gustaria Trabajar o Estudiar?");
                }
                else{
                    lblPregunta.setText("¿Sentis que tu pareja ya no te escucha o no te presta atención?");
                    ban = 3;
                }
                break;
            //Regla 2
            case 2:
                if(c.equals("si")){
                    dependiente = true;
                    ban=3;
                }
                lblPregunta.setText("¿Sentis que tu pareja ya no te escucha o no te prestan atención?");
                break;

            case 3:
                if(c.equals("si")){
                    desatentido = true;
                    ban=4;
                    lblPregunta.setText("¿Tu pareja te apoya en lo que haces?");
                }
                else {
                    ban=5;
                    lblPregunta.setText("¿Visistas seguido a tu flia o amigos?");
                }
                break;
            case 4:
                if(c.equals("no")){
                    indicioPSY1 = true;
                    ban=5;
                    lblPregunta.setText("¿Visistas seguido a tu flia o amigos?");
                }
                else{
                    ban=9;
                    lblPregunta.setText("¿Discutes seguido con  tu pareja?");
                }

                break;
            case 5:
                if(c.equals("no")){
                    aislado = true;
                    ban=6;
                    lblPregunta.setText("¿Siempre que salis lo haces con tu pareja?");
                }
                else{
                    ban=9;
                    lblPregunta.setText("¿Discutes seguido con  tu pareja?");
                }
                break;
            case 6:
                if(c.equals("si")){
                    controlado = true;
                    ban=7;
                    lblPregunta.setText("¿Tu pareja controla tus mensajes o tus llamadas?");
                }
                else{

                }
                break;
            case 7:
                if(c.equals("si")){
                    indicioPSY2 = true;
                    ban=9;
                    lblPregunta.setText("¿Discutes seguido con  tu pareja?");
                }
                else{
                    ban=8;
                    lblPregunta.setText("¿Tu pareja te cela o te pide explicaciones por todo lo que haces?");
                }
                break;
            case 8:
                if(c.equals("si")){
                    ban=9;
                    indicioPSY2 = true;
                    lblPregunta.setText("¿Discutes seguido con  tu pareja?");
                }
                break;
            case 9:
                if(c.equals("si")) {
                    ban = 10;
                    conflicto = true;
                    lblPregunta.setText("¿Tu pareja te hace gestos despectivos o se burla de ti?");

                }
                else {
                    ban=13;
                    //lblPregunta.setText("¿Te expresas con libertad sin miedo de contradecir a tu pareja?");
                    lblPregunta.setText("¿Dañó alguna vez a propósito tus poseciones?");

                }
                break;
            case 10:
                if(c.equals("si")){
                    ban=12;
                    discriminada = true;
                    lblPregunta.setText("¿Te ha empujado, pellizcado o golpeado?");
                }
                else {
                    ban = 11;
                    lblPregunta.setText("¿Te ha gritado o asustado de forma temeraria y amenazante?");
                }
                break;
            case 11:
                if(c.equals("si")){
                    ban=12;
                    amenazado = true;
                }
                lblPregunta.setText("¿Te ha empujado, pellizcado o golpeado?");
                break;
            case 12:
                if(c.equals("si")){
                    golpeado = true;
                    lblPregunta.setText("¿Dañó alguna vez a propósito tus poseciones?");
                }
                ban=13;
                break;
            case 13:
                if(c.equals("si")){
                    vioPatrimonial = true;
                    lblPregunta.setText("Presiona si para continuar con el diagnostico...");
                }
                ban=14;
                break;
            case 14:
                if(indicioPSY1==true || indicioPSY2==true || discriminada ==true){
                    cadena = "Violencia psicologica - ";
                }
                if (dependiente == true && controlado == true){
                    cadena = cadena + "Violencia economica - ";
                }
                if(golpeado == true){
                    cadena = cadena + "Violencia Fisica - ";
                }
                if(vioPatrimonial == true){
                    cadena = cadena + "Violencia Patrimonial - ";
                }
               lblPregunta.setText("Cuidado: usted sufre de:" + cadena);
                ban=0;
                break;
        }

    }
}
