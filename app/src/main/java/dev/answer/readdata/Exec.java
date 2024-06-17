package dev.answer.readdata;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.function.Function;
import rikka.shizuku.Shizuku;
import rikka.shizuku.ShizukuRemoteProcess;

/**
 * @Author AnswerDev
 * @Date 2024/06/17 19:24
 */

public class Exec {

    public static ShizukuRemoteProcess newProcess(String[] e, String[] cmd, String env) {
        ShizukuRemoteProcess process = null;
        try {
            Method method = Shizuku.class.getDeclaredMethod("newProcess", String[].class, String[].class, String.class);
            method.setAccessible(true);
            process = (ShizukuRemoteProcess) method.invoke(null, e, cmd, env);

        } catch (Exception err) {
            err.printStackTrace();
        }
        return process;
    }

    public static void ShizukuExec(String cmd, final Function<String, String> result, final Function<String, String> error, final Function<String, String> exit) {
        try {
            final ShizukuRemoteProcess p = Exec.newProcess(new String[]{"sh"}, null, "/system/bin/");
            OutputStream out = p.getOutputStream();
            out.write((cmd + "\nexit\n").getBytes());
            out.flush();
            out.close();

            Thread h2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            BufferedReader mReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                            String inline;
                            while ((inline = mReader.readLine()) != null) {
                                String str = inline.equals("") ? "\n" : inline + "\n";
                                if(result!=null)result.apply(str);
                            }
                            mReader.close();
                        } catch (Exception ignored) {
                        }
                    }
                });
            h2.start();

            Thread h3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            BufferedReader mReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                            String inline;
                            while ((inline = mReader.readLine()) != null) {
                                String str = "";
                                if (inline.equals(""))
                                    str = null;
                                else {
                                    str = inline + "\n";
                                }
                                if(error!=null)error.apply(str);
                            }
                            mReader.close();
                        } catch (Exception ignored) {
                        }
                    }
                });
            h3.start();
            p.waitFor();
            
            String exitValue = String.valueOf(p.exitValue());
            if(exit != null)exit.apply(exitValue);

        } catch (Exception ignored) {

        } 
    }
    
    public static boolean checkPermission(int code) {
        if (Shizuku.isPreV11()) {
            return false;
        }
        if (Shizuku.checkSelfPermission() == 0) {
            return true;
        }
        if (Shizuku.shouldShowRequestPermissionRationale()) {
            return false;
        }
        Shizuku.requestPermission(code);
        return false;
    }

}
