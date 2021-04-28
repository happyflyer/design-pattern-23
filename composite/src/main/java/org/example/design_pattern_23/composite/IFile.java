package org.example.design_pattern_23.composite;

import java.util.List;

/**
 * @author lifei
 */
public interface IFile {
    /**
     * display
     */
    void display();

    /**
     * add
     *
     * @param file file
     * @return boolean
     */
    boolean add(IFile file);

    /**
     * remove
     *
     * @param file file
     * @return boolean
     */
    boolean remove(IFile file);

    /**
     * getChild
     *
     * @return List
     */
    List<IFile> getChild();
}
