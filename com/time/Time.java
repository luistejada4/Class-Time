package com.time;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Time {

    private int hora;
    private int minutos;
    private int segundos;
    private Timer timer;


    public void setTime(int h, int m, int s) {
        
        
        hora = ((h <= 24) ? h:0);
        minutos = ((h <= 59) ? m:0);
        segundos = ((h <= 59) ? s:0);
        ActionListener taskPerformer = new ActionListener() {
        
            public void actionPerformed(ActionEvent evt) {
                
                if(segundos < 60)
                {
                    segundos++;
                }
                else
                {
                    segundos = 0;
                    if(minutos < 60)
                    {
                        minutos++;
                    }
                    else
                    {
                        minutos = 0;
                        if(hora < 23)
                        {
                            hora++;
                        }
                        else 
                        {
                            hora = 0;
                        }
                    }
                }
            }
        };
        if(timer == null)
        {
            timer = new Timer(1000 ,taskPerformer);
            timer.setRepeats(true);
            timer.start();
        }

    }
    public void stopTime() {

        timer.stop();
    }
    public String UniversalFormat()
    {
        return String.format("%02d:%02d:%02d %s", hora, minutos, segundos, (hora >= 12 ? "PM":"AM"));
    }
    public String format12()
    {
        return String.format("%02d:%02d:%02d %s", hora-12, minutos, segundos, (hora >= 12 ? "PM":"AM"));
    }
}