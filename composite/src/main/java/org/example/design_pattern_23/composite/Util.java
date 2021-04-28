package org.example.design_pattern_23.composite;

import java.util.List;

/**
 * @author lifei
 */
public class Util {
    public static void displayTree(IFile iFile, int deep) {
        for (int i = 0; i < deep; i++) {
            System.out.print("--");
        }
        iFile.display();
        List<IFile> children = iFile.getChild();
        for (IFile file : children) {
            if (file instanceof File) {
                for (int i = 0; i <= deep; i++) {
                    System.out.print("--");
                }
                file.display();
            } else {
                displayTree(file, deep + 1);
            }
        }
    }
}
