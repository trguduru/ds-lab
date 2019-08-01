package org.tguduru.ds.lab.tree;

import org.tguduru.ds.lab.linkedlists.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified 6/23/16.
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    @Override
    public Position<E> sibling(Position<E> position) {
        Position<E> parent = parent(position);
        if (parent == null) return null;
        if (position == left(parent))
            return right(parent);
        else
            return left(parent);
    }

    @Override
    public int numChildren(Position<E> position) throws IllegalStateException {
        if (position == null)
            throw new IllegalStateException("Cannot find children for null node");
        int children = 0;
        if (left(position) != null)
            children++;
        if (right(position) != null)
            children++;
        return children;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> position) throws IllegalStateException {
        if (position == null)
            throw new IllegalStateException("Cannot find children for null node");
        List<Position<E>> children = new ArrayList<>(2);
        if (left(position) != null)
            children.add(left(position));
        if (right(position) != null)
            children.add(right(position));
        return children;
    }
}
