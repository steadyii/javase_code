package com.steady.d9_lambda.timer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.awt.event.ActionEvent;

@SpringBootTest
public class TimerTest {
    @Test
    void testApi(){
        Timer timer = new Timer(1000, TimerTest::greet);
        timer.start();
    }
    
    public static void greet(ActionEvent e){
        System.out.println("greet!?");
    }
}
