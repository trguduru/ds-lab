package io.tguduru.ds.lab.tree;

import io.tguduru.ds.lab.linkedlists.Position;

/**
 * @author Guduru, Thirupathi Reddy
 * @modified 6/23/16.
 */
public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isRoot(Position<E> position) {
        return position == root();
    }

    @Override
    public boolean isExternal(Position<E> position) {
        return numChildren(position) == 0;
    }

    @Override
    public boolean isInternal(Position<E> position) {
        return numChildren(position) > 0;
    }

    /**
     * Calculates the depth of a node
     * @param position
     * @return
     */
    public int depth(Position<E> position){
        if(isRoot(position))
            return 0;
        return 1 + depth(parent(position));
    }

    /**
     * Calculates the height of the node
     * @param position
     * @return
     */
    public int height(Position<E> position){
        int h = 0;
        for(Position<E> p : children(position)){
            h = Math.max(h, 1 + height(p));
        }
        return h;
    }
}
