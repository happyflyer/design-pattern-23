package org.example.design_pattern_23.composite;

import org.junit.Test;

public class FileTest {
    @Test
    public void test() {
        IFile rootFolder = new Folder("C:");
        IFile beiFengFolder = new Folder("beifeng");
        IFile beiFengFile = new File("beifeng.txt");
        rootFolder.add(beiFengFolder);
        rootFolder.add(beiFengFile);
        IFile iBeifengFolder = new Folder("ibeifeng");
        IFile iBeifengFile = new File("ibeifeng.txt");
        beiFengFolder.add(iBeifengFolder);
        beiFengFolder.add(iBeifengFile);
        IFile iiBeifengFolder = new Folder("iibeifeng");
        IFile iiBeifengFile = new File("iibeifeng.txt");
        iBeifengFolder.add(iiBeifengFolder);
        iBeifengFolder.add(iiBeifengFile);
        Util.displayTree(rootFolder, 0);
    }
}
