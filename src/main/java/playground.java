import nz.sodium.Cell;
import nz.sodium.Stream;
import swidgets.SButton;
import swidgets.SLabel;

import javax.swing.*;
import java.awt.*;

public class playground {
    public static void main(String[] args) {
        JFrame view = new JFrame();
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setLayout(new FlowLayout());
        SButton red = new SButton("red");
        SButton green = new SButton("green");
        Stream<String> sGreen = green.sClicked.map(u -> "green");
        Stream<String> sRed = red.sClicked.map(u -> "red");
        Stream<String> sColor = sRed.orElse(sGreen);
        Cell<String> color = sColor.hold("");
        SLabel lbl = new SLabel(color);
        view.add(red);
        view.add(green);
        view.add(lbl);
        view.setSize(400, 160);
        view.setVisible(true);
    }
}
