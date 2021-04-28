package org.example.design_pattern_23.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lifei
 */
public class Folder implements IFile {
    private final String name;
    private final List<IFile> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    @Override
    public void display() {
        System.out.println(name);
    }

    @Override
    public boolean add(IFile file) {
        return this.children.add(file);
    }

    @Override
    public boolean remove(IFile file) {
        return this.children.remove(file);
    }

    @Override
    public List<IFile> getChild() {
        return children;
    }
}
