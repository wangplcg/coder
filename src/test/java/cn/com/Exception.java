package cn.com;

import org.apache.commons.lang3.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Description:
 * User: wangpl
 * Date: 2019-09-29
 * Time: 10:19
 */

public class Exception {

    public static void main(String[] args) {
        String encode = "I2UDO1MTO5cjNiojItR0ZqpneiwiIwADMwUTMxATMzEjI6ISbEpmZrN3dzdmeiwiIwADMwUTMxATMzEjI6ISbEp2dzdmeiwiIwAjMwMTMiojItRkezhWc6hnekNmeiwiIyEzMyEzMyEzMyEzMyEjKqoirUWutbmOgdWOscWOjGWOqzauI6IiekNmeiwiIZJiOionY4lnIsIiI6ICaiNncz5WeiwiI3MjO5EjOwEDIyATL5ATL0EDMyIiOiEncnhnIsIiN0YTMwAjMwUjNxIiOi0GRydGeiwiIZJiOionYsJmakd3ciwiIwADMwUTMxATMzEjI6ISbElHbnN3ciwiI3gDM0ETM2UDMwADMyAzMxETMwEjI6ICaiFGZzNnIsIiI6IiaTJGdqNnIsICMwADM1ETMwEzMxIiOiEHZzdmazJCLiATMwADMxAjMxEDNykDM3EDMyIiOi0GZ5hHazJCLiADMyAzMxIiOi0GR6NHaxpHe6RWeqN2ciwiI4MzNz86to/qjnfZjlbqjlfKplv4jl7IqnDYnlDLnlXKko/4unfquk/JlnLiOioHZ5p2YzJCLiIiOi0GR4xGd6J3cuJCLiMDMiojItREd6J3cuJCLiADMwADMwADMwADMwADM5EDMyIiOigmYzJ3cuJCLiMztPWup0ievDi+h4S+t1aui4SuI6IyYtJ3cuJCLiIiOiknWyNnbiwiI0UjOwAjOyEDIzITLwETL4ADMyIiOiEncyxmIsIyM0YTMwAjMwUjNxIiOi0GRyJHbiwiIwETMxIiOi0GR4xmakRne6tmIsIiTiojI6JmakRnezN2YxtmIsIiNwEzMyIDMzEjI6ISbEpHekpmIsICMwgDNiojItRUeoJCLiEjI6ISbEhHbzR2ZiwiIxIiOi0GR4xGanR2ZiwiIOJiOionY5FXbqZmIsIiu7WugBiuI6ISb4JnYkRmZiwiIxAjMiojItREespmemNnciRGZmJCLiAzMyETNxkDM4YTOxMzM1IzMxIiOi0GaqpnZzJnYkRmZiwiIyYjI6ISbEh3Zzx2dkJCLiEzM0IiOi0GR4x2Y6pGZiwiIwADMwADMwADMwgTM5ADOwkTMwIjI6ICa4pGZiwiIwAjOwAjOwADI0ATL3ATL3EDMyIiOiEncqRmIsICMwADMwADMwEzMxIiOi0GRnpmakJyen0=";
        String encoded = org.apache.commons.lang3.StringUtils.reverse(org.apache.commons.lang3.StringUtils.substring(encode, 0, -3)) + org.apache.commons.lang3.StringUtils.substring(encode, -3);
        System.out.println(encoded);
    }

    public static String getExceptionToString(Throwable e) {
        if (e == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}