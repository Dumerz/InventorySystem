/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author MRI-User
 */
public class SplashScreenInterface {
    
    public SplashScreen mySplash;
    private Font font;
    private Graphics2D splashGraphics;
    private Rectangle2D splashProgressArea;
    private Rectangle2D splashTextArea;
    
    public SplashScreenInterface() {
        
    }
    
    public void splashInit() {
        mySplash = SplashScreen.getSplashScreen();
        if (mySplash != null) {
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;
            splashTextArea = new Rectangle2D.Double(15., height*0.88, width * .45, 32.);
            splashProgressArea = new Rectangle2D.Double(width * .55, height*.92, width*.4, 12 );
            splashGraphics = mySplash.createGraphics();
            font = new Font("Dialog", Font.PLAIN, 14);
            splashGraphics.setFont(font);
            splashText("Starting");
            splashProgress(0);
        }
    }
    
    public void splashText(String str) {
        if (mySplash != null && mySplash.isVisible()) {
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.fill(splashTextArea);
            splashGraphics.setPaint(Color.BLACK);
            splashGraphics.drawString(str, (int)(splashTextArea.getX() + 10),(int)(splashTextArea.getY() + 15));
            mySplash.update();
        }
    }
    
    public void splashProgress(int pct) {
        if (mySplash != null && mySplash.isVisible()) {
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.fill(splashProgressArea);
            // draw an outline
            splashGraphics.setPaint(Color.BLUE);
            splashGraphics.draw(splashProgressArea);
            // Calculate the width corresponding to the correct percentage
            int x = (int) splashProgressArea.getMinX();
            int y = (int) splashProgressArea.getMinY();
            int wid = (int) splashProgressArea.getWidth();
            int hgt = (int) splashProgressArea.getHeight();
            int doneWidth = Math.round(pct*wid/100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, wid-1));
            splashGraphics.setPaint(Color.GREEN);
            splashGraphics.fillRect(x, y+1, doneWidth, hgt-1);
            mySplash.update();
        }
    }
    
    public void appInit() {
        for(int i=1;i<=10;i++) {
            int pctDone = i * 10;
            splashText("Loading Components " + pctDone + "%");
            splashProgress(pctDone);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e);
            }
        }
    }

}
