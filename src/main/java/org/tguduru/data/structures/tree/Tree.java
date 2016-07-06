package org.tguduru.data.structures.tree;

import javafx.geometry.Pos;
import org.tguduru.data.structures.linkedlists.Position;

import java.util.Iterator;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified 6/23/16.
 */
public interface Tree<E> extends Iterable<E> {
    Position<E> root();
    Position<E> parent(Position<E> position) throws IllegalStateException;
    Iterable<Position<E>> children(Position<E> position) throws IllegalStateException;
    int numChildren(Position<E> position) throws IllegalStateException;
    boolean isInternal(Position<E> position);
    boolean isExternal(Position<E> position);
    boolean isRoot(Position<E> position);
    boolean isEmpty();
    int size();
    Iterator<E> iterator();
    Iterable<Position<E>> positions();
    void add(E data);
    Position<E> find(E data);
}
