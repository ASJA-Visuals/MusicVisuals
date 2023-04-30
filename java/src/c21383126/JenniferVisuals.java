package c21383126;

import ie.tudublin.visual.VObject;
import ie.tudublin.visual.VScene;
import ie.tudublin.visual.Visual;
import processing.core.PApplet;
import processing.core.PVector;
import ddf.minim.AudioBuffer;
import ddf.minim.Minim;

public class JenniferVisuals extends VScene {
    Visual v;
    VObject speaker;
    VObject circle;
    VObject cw;
    VObject guitar;

    Minim minim;
    AudioBuffer ab;

   
    public JenniferVisuals(Visual v) {
        super(v);
        this.v = v;
        speaker = new Speaker(v, new PVector(v.width/4, v.height/4));
        circle = new Circles(v, new PVector(v.width/4, v.height/4));
        cw = new CircleWave(v, new PVector(v.width/4, v.height/4));
        guitar = new Guitar(v, new PVector(v.width/4, v.height/4));


        minim = new Minim(this);
        ab = v.audioPlayer().mix;

    }

    public void render(int elapsed) {
      
        // 1:03 - 1:48 - Second verse & chorus
        if (elapsed > v.toMs(1, 3,0) && elapsed < v.toMs(1, 48, 0)) 
        {
            //speaker.render();
            //circle.render();   
            //cw.render();   
            guitar.render();            
        }
        System.out.println(elapsed);
    }

    class Guitar extends VObject{
        Guitar(Visual v, PVector pos){
            super(v, pos);
        }

        @Override
        public void render(){
            v.fill(100, 100, 100);
            v.stroke(100, 100, 100);
            v.triangle(50, 100, 50, 700, 700, 400 );
            v.noStroke();
            v.fill(0);
            v.triangle(50, 100, 50, 700, 200, 400);

            float[] ab = v.audioAnalysis().mix().waveform;
            v.pushMatrix();
            v.beginShape();
            for (int i = 0; i < ab.length; i++) {
                float x1 = PApplet.map(i, 0, ab.length, 200, v.width);
                float y1 = PApplet.map(ab[i], -1, 1, 370, 390);
                v.stroke(255);
                v.noFill();
                v.vertex(x1, y1);
            }
            v.endShape();
            v.popMatrix();

            v.pushMatrix();
            v.beginShape();
            for (int i = 0; i < ab.length; i++) {
                float x1 = PApplet.map(i, 0, ab.length, 200, v.width);
                float y1 = PApplet.map(ab[i], -1, 1, 390, 410);
                v.stroke(255);
                v.noFill();
                v.vertex(x1, y1);
            }
            v.endShape();
            v.popMatrix();

            v.pushMatrix();
            v.beginShape();
            for (int i = 0; i < ab.length; i++) {
                float x1 = PApplet.map(i, 0, ab.length, 200, v.width);
                float y1 = PApplet.map(ab[i], -1, 1, 410, 430);
                v.stroke(255);
                v.noFill();
                v.vertex(x1, y1);
            }
            v.endShape();
            v.popMatrix();

        }
    }

    class CircleWave extends VObject{
        CircleWave(Visual v, PVector pos){
            super(v, pos);
        }

        @Override 
        public void render(){
            v.noFill();
            v.translateCenter();
            v.beginShape();
            for (int i = 0; i< ab.size(); i++)
            {
                float c = PApplet.map(ab.get(i), -1, 1, 0, 360);
                v.stroke(c, 100, 100);
                float angle = PApplet.map(i, 0, ab.size(), 0, PApplet.TWO_PI);
                float radius = ab.get(i) * 1000 + 100;
                float x1 = PApplet.sin(angle) * radius;
                float y1 = -PApplet.cos(angle) * radius;
                v.vertex(x1, y1);
                v.fill(0);
                v.circle(0, 0, radius-1);
            }
            v.endShape();

        }
    }

    class Circles extends VObject {
        Circles(Visual v, PVector pos){
            super(v, pos);
        }

        @Override
        public void render(){
            for (int i=0; i<360; i++)
            {
                // (x2, y2) (x3, y3)
                //     (x1, x2)
                // (x4, y4) (x5, y5)

                v.stroke(109, 247, 240);
                float f = ab.get(i) * v.height/2;
                double x1 = v.width/2 + (Math.cos(i)*(Math.PI/180) * 100 * f);
                double y1 = v.height/2 + (Math.sin(i)*(Math.PI/180) * 100 * f);
                v.line(v.width/2, v.height/2, (float)x1, (float)y1);

                v.stroke(176, 65, 240);
                double x2 = v.width/4 + (Math.cos(i)*(Math.PI/180) * 100 * f);
                double y2 = v.height/4 + (Math.sin(i)*(Math.PI/180) * 100 * f);
                v.line(v.width/4, v.height/4, (float)x2, (float)y2);

                double x3 = 3*v.width/4 + (Math.cos(i)*(Math.PI/180) * 100 * f);
                double y3 = v.height/4 + (Math.sin(i)*(Math.PI/180) * 100 * f);
                v.line(3*v.width/4, v.height/4, (float)x3, (float)y3);

                double x4 = v.width/4 + (Math.cos(i)*(Math.PI/180) * 100 * f);
                double y4 = 3*v.height/4 + (Math.sin(i)*(Math.PI/180) * 100 * f);
                v.line(v.width/4, 3*v.height/4, (float)x4, (float)y4);

                double x5 = 3*v.width/4 + (Math.cos(i)*(Math.PI/180) * 100 * f);
                double y5 = 3*v.height/4 + (Math.sin(i)*(Math.PI/180) * 100 * f);
                v.line(3*v.width/4, 3*v.height/4, (float)x5, (float)y5);
                
            }
        }
    }

    class Speaker extends VObject {

        Speaker(Visual v, PVector pos){
            super(v, pos);
        }

        @Override
        public void render(){
            v.stroke(255);

            // (x1,y1) (x3,y3)
            // (x2,y2) (x4,y4)
            
            int x1 = v.width/3;
            int y1 = v.height/3;
            int x2 = v.width/3;
            int y2 = v.height/3 * 2;
            int x3 = v.width/3 * 2;
            int y3 = v.height/3;
            int x4 = v.width/3 * 2;
            int y4 = v.height/3 * 2;

            //int radius = 100;
            int border = 105;            

            int length = ((y2 + border) - (y1 - border));
            int width = ((x2 + border) - (x1 - border));
            v.fill(100);
            v.rect(x1 - border, y1 - border, width, length);

            v.rect(x3 - border, y3 - border, width, length);

            v.noStroke();
            v.frameRate(1); 
            v.noFill();

            for(int i=0; i< ab.size(); i++)
            {
                float c = PApplet.map(ab.get(i), -1, 1, 0, 360);
                v.stroke(c, 100, 100);
                float radius = ab.get(i) * 1000 + 100;
                v.circle(x1, y1, radius-1);
                v.circle(x2, y2, radius-1);
                v.circle(x3, y3, radius-1);
                v.circle(x4, y4, radius-1);
            }

            /*
            float h = v.random(ab.get(radius), 360);
            for (int r = radius; r > 0; --r) {
                v.fill(h, 90, 90);
                v.ellipse(x1, y1, r, r);
                v.ellipse(x2, y2, r, r);
                v.ellipse(x3, y3, r, r);
                v.ellipse(x4, y4, r, r);
                h = (h + 1) % 360;
            }    
            */
        }
        
    }

}
