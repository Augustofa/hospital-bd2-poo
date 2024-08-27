/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Geral;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author augus
 */
public class Utils {
    public static String converteStringToSqlDate(String dataString){
        String sqlDataString = "";
        SimpleDateFormat formatoSimples = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoSql = new SimpleDateFormat("yyyy-MM-dd");

        try {

            sqlDataString = formatoSql.format(formatoSimples.parse(dataString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return sqlDataString;
    }
    
    public static String converteSqlDateToString(String sqlDataString){
        String dataString = "";
        SimpleDateFormat formatoSimples = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoSql = new SimpleDateFormat("yyyy-MM-dd");

        try {

            dataString = formatoSimples.format(formatoSql.parse(sqlDataString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return dataString;
    }
}
