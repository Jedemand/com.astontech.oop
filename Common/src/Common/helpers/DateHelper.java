package Common.helpers;


public class DateHelper {
    public static java.sql.Date utilDateToSQLDate(java.util.Date date){
        return new java.sql.Date(date.getTime());
    }

    public static java.util.Date sqlDateToJavaDate(java.sql.Date date){
        return new java.util.Date(date.getTime());
    }
}
