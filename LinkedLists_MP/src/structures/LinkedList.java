package structures;

/**
 * A class to provide the basic methods of a singly linked list. Note that it is
 * simplified in that it does not implement or extend List, Collection, etc. It
 * is for learning the basics of Linked Lists.
 *
 * @author Mason Perrella
 * @version 1.0 2 March 2002
 * @version 1.1 19 November 2013
 * @param <T>
 */
public class LinkedList<E>
{
    /////////////////////////////
    // Properties //
    /////////////////////////////
    private Node<E> myHead;
    private int mySize;

    /////////////////////////////
    // Methods //
    /////////////////////////////

    /**
     * Default constructor that creates an empty linked list
     *
     * <pre>
     *  pre:  the linked list is empty
     *  post: the linked list is empty
     * </pre>
     */
    public LinkedList()
    {
        myHead = null;
        mySize = 0;
    }

    /**
     * Constructor that creates a new linked list with a single node storing the
     * object passed in
     *
     * <pre>
     *  pre:  myHead points to null (the linked list is empty)
     *  post: myHead points to the only node in the linked list,
     *        that node holding the object passed in
     * </pre>
     *
     * @param datum
     *            an object to be inserted at the head of the linked list
     */
    public LinkedList(Object datum)
    {
        myHead = new Node<E>(datum);
        myHead.setNext(null);
    }

    /**
     * Adds a node to the head of the linked list; the special condition of an
     * empty linked list is handled without special treatment since if myHead
     * points to null, that simply becomes the next node in the list,
     * immediately following the new entered node at the head of the list
     *
     * <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the beginning of the list
     * </pre>
     *
     * @param aNode
     *            the node to be entered
     */
    private void addFirst(Node<E> aNode)
    {
        aNode.setNext(myHead);
        myHead = aNode;

    }

    /**
     * Adds a node to the head of the linked list; the special condition of an
     * empty linked list is handled without special treatment since if myHead
     * points to null, that simply becomes the next node in the list,
     * immediately following the new entered node at the head of the list
     *
     * <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the beginning of the list
     * </pre>
     *
     * @param datum
     *            the object used to creat a new node to be entered at the head
     *            of the list
     */
    public void addFirst(Object datum)
    {
        Node<E> aNode;

        aNode = new Node<E>(datum);
        this.addFirst(aNode);
        mySize++;
    }

    /**
     * Adds a node to the tail of the linked list; the special condition of an
     * empty linked list is handled separately
     *
     * <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the end of the list
     * </pre>
     *
     * @param aNode
     *            the node to be entered
     */
    private void addLast(Node<E> aNode)
    {
        Node<E> lastNode;

        if (myHead == null)
        {
            this.addFirst(aNode);
        } else
        {
            lastNode = this.getPrevious(null);
            lastNode.setNext(aNode);
            aNode.setNext(null);
        }
    }

    /**
     * Adds a node to the tail of the linked list; the special condition of an
     * empty linked list is handled separately
     *
     * <pre>
     *  pre:  the linked list may be empty or contain one or
     *        more nodes
     *  post: the linked list contains one more node that has
     *        been added to the end of the list
     * </pre>
     *
     * @param datum
     *            the object used to creat a new node to be entered at the tail
     *            of the list
     */
    public void addLast(Object datum)
    {
        Node<E> aNode;

        aNode = new Node<E>(datum);
        this.addLast(aNode);
        mySize++;
    }

    /**
     * Deletes a node from the list if it is there
     *
     * <pre>
     *  pre:  the list has 0 or more nodes
     *  post: if the node to be deleted is in the list,
     *        the node no longer exists in the list; the
     *        node previous to the node to be deleted now
     *        points to the node following the deleted node
     * </pre>
     *
     * @param aNode
     *            the node to be deleted from the list
     *
     * @return boolean indicating whether or not the node was deleted
     */
    private boolean remove(Node<E> aNode)
    {
        Node<E> currentNode;
        currentNode = myHead;
        boolean check = false;
        if (currentNode == aNode)
        {
            this.removeFirst();
            check = true;
            return check;
        } else if (getPrevious(null) == aNode)
        {

            this.removeLast();
            check = true;
            return check;
        } else
        {
            while (currentNode != null)

            {
                if (currentNode == aNode)
                {

                    getPrevious(currentNode).setNext(currentNode.getNext());
                    mySize--;
                    check = true;
                    break;

                } else
                {
                    currentNode = currentNode.getNext();
                }
            }
        }
        return check;
    }

    /**
     * Deletes a node from the list if it is there
     *
     * <pre>
     *  pre:  the list has 0 or more nodes
     *  post: if the node to be deleted is in the list,
     *        the node no longer exists in the list; the
     *        node previous to the node to be deleted now
     *        points to the node following the deleted node
     * </pre>
     *
     * @param datum
     *            the object to be deleted from the list
     *
     * @return boolean indicating whether or not the node was deleted
     */
    public boolean remove(Object datum)
    {
        Node<E> aNode;

        aNode = findNode(datum);
        if (remove(aNode))
        {

            return true;
        } else
        {
            return false;
        }
    }

    /**
     * Find a node in the list with the same data as that passed in
     *
     * <pre>
     *  pre:  the list has 0 or more nodes
     *  post: list is unchanged
     * </pre>
     *
     * @param datum
     *            the object for which a node is to be found in the list
     *
     * @return null if a node with the given object datum is not in the list, or
     *         the node if it does
     */
    private Node<E> findNode(Object datum)
    {
        Node<E> currentNode;
        Object currentDatum;

        currentNode = myHead;
        currentDatum = null;

        while (currentNode != null)
        {
            currentDatum = currentNode.getData();
            if (currentDatum.equals(datum))
            {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    /**
     * Determine if a node exists in the list with the same data as that passed
     * in
     *
     * <pre>
     *  pre:  the list has 0 or more nodes
     *  post: list is unchanged
     * </pre>
     *
     * @param datum
     *            the object for which a node is to be found in the list
     *
     * @return false if a node with the given object datum is not in the list,
     *         or true if it does
     */
    public boolean contains(Object datum)
    {
        Node<E> aNode;
        aNode = new Node<E>();
        aNode = findNode(datum);
        if (aNode != null)
        {
            return true;
        } else
        {
            return false;
        }
    }

    /**
     * Determines the node that resides one closer to the head of the list than
     * the node passed in
     *
     * <pre>
     *  pre:  the list has 0 or more nodes
     *  post: the list is unchanged
     * </pre>
     *
     * @param aNode
     *            the node whose predecessor is being looked for
     *
     * @return the node that resides one closer to the head of the list than the
     *         node passed in
     */
    private Node<E> getPrevious(Node<?> aNode)
    {
        Node<E> currentNode;

        currentNode = myHead;

        if (currentNode == aNode)
        {
            return null;
        }

        while (currentNode != null && currentNode.getNext() != aNode)
        {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    /**
     * A new node is entered into the list immediately before the designated
     * node
     *
     * <pre>
     *  pre:  the list may have 0 or more nodes in it
     *  post: if the beforeNode is not in the list, no change
     *        takes place to the list; otherwise, the new
     *        node is entered in the appropriate place
     * </pre>
     *
     * @param aNode
     *            the node to be entered into the list
     * @param beforeNode
     *            the node before which the new node is to be entered
     *
     * @return boolean designating if the node was or was not entered into list
     */
    private boolean insertBefore(Node<E> aNode, Node<E> beforeNode)
    {
        Node<E> previous;
        boolean check = false;
        previous = this.getPrevious(beforeNode);

        if (beforeNode != null)
        {
            if (myHead == beforeNode)
            {
                this.addFirst(aNode);
                check = true;
                return check;
            } else
            {
                aNode.setNext(beforeNode);
                previous.setNext(aNode);
                check = true;
                mySize++;
                return check;
            }
        }
        return check;
    }

    /**
     * A new node with datum is entered into the list immediately before the
     * node with beforeDatum, the designated node
     *
     * <pre>
     *  pre:  the list may have 0 or more nodes in it
     *  post: if the node with beforeDatum is not in the list, 
     *        no change takes place to the list; otherwise, a new
     *        node is entered in the appropriate place with the 
     *        object datum
     * </pre>
     *
     * @param datum
     *            the object used to create the new node to be entered into the
     *            list
     * @param beforeDatum
     *            the datum of the node before which the new node is to be
     *            entered
     *
     * @return boolean designating if the node was or was not entered
     */
    public boolean insertBefore(Object datum, Object beforeDatum)
    {
        Node<E> aNode, beforeNode;
        aNode = new Node<E>(datum);
        aNode.setData(datum);
        beforeNode = findNode(beforeDatum);
        if (insertBefore(aNode, beforeNode))
        {

            return true;
        } else
        {
            return false;
        }
    }

    /**
     * print the list by converting the objects in the list to their string
     * representations
     *
     * <pre>
     *  pre:  the list has 0 or more elements
     *  post: no change to the list
     * </pre>
     */
    public String toString()
    {
        String string;
        Node<E> currentNode;

        currentNode = myHead;

        string = "head ->";

        while (currentNode != null)
        {
            string += currentNode.getData().toString() + " -> ";
            currentNode = currentNode.getNext();
        }
        string += "|||";
        return string;
    }

    // ALSO! Comment and implement the following methods.
    // !!!

    /**
     * 
     * 
     * @param o
     * @return
     */
    public int indexOf(Object o)
    {
        int counter = 0;
        Node<E> currentNode = new Node<E>();
        Node<E> endNode = new Node<E>();
        currentNode = this.getHead();
        endNode = findNode(o);
        if(endNode != null)
        {
            while (currentNode != null)
            {
                counter++;
                if(currentNode == endNode)// if you reach the node looking for 
                {
                    break;// end the search
                }else
                {
                currentNode = currentNode.getNext();
                }
            }
         
        } 
           
        return counter;
    }

    /**
     * Removes the first Object from the linked list and returns that object.
     * 
     * @return
     */
    public Object removeFirst()
    {
        if (this.size() == 0)
        {
            return this;
        } else
        {

            myHead = myHead.getNext();
            mySize--;
        }
        return this;
    }

    /**
     * 
     * Removes the last Object from the linked List and returns that object
     * 
     * @return
     *
     */
    public Object removeLast()
    {
        Node<E> last;

        last = this.getPrevious(null);
        if (this.size() == 0)
        {
            return this;
        } else if (last == myHead)
        {

            // myHead.setNext(last.getNext());
            removeFirst();
        } else
        {

            getPrevious(last).setNext(null);
            mySize--;
        }

        return this;

    }

    /**
     * Checks the size of the linked list by counting the number of Nodes.
     * Returns the integer
     * 
     * @return
     */
    public int size()
    {
        return mySize;

    }

    /**
     * Returns the first object in the list.
     * 
     * @return
     */
    public Object getFirst()
    {
        Object first;
        if (getHead() != null)
        {
            first = this.getHead().getData();
            return first;

        } else
        {
            return null;
        }

    }

    /**
     * Returns the last object in the list.
     * 
     * @return
     */
    public Object getLast()
    {
        Object last;
        if (this.getPrevious(null) == null)
        {
            return null;
        } else
        {
            last = this.getPrevious(null).getData();
            return last;
        }

    }

    /**
     * Makes the Object being passed in the first object in the list. And the
     * head.
     * 
     * @param o
     */
    public void setFirst(Object o)
    {
        Node<E> currentO;

        currentO = myHead;
        currentO.setData(o);
        
    }

    // Assessor methods
    private void setHead(Node<E> aNode)
    {
        myHead = aNode;
    }

    private Node<E> getHead()
    {
        return myHead;
    }

    /**
     * 
     * Private Node class
     * 
     */
    /**
     * Provides the basic structure of a linked-list node
     *
     * @author Mason Perrella
     * @version 1.0 2 March 2002
     */
    public class Node<T>
    {
        ///////////////////////////////////
        // Properties //
        ///////////////////////////////////
        private Object myData;
        private Node<T> myNext;

        ///////////////////////////////////
        // Methods //
        ///////////////////////////////////

        /**
         * Default constructor for a node with null data and pointer to a next
         * node
         */
        public Node()
        {
            myData = null;
            myNext = null;
        }

        /**
         * Constructor for a node with some object for its data and null for a
         * pointer to a next node
         *
         * <pre>
         *  pre:  a null node
         *  post: a node with some object for its data and
         *        null for a pointer to a next node
         * </pre>
         *
         * @param datum
         *            an object for the node's data
         */
        public Node(Object datum)
        {
            myData = datum;
            myNext = null;
        }

        /**
         * Constructor for a node with some object for its data and a pointer to
         * another node
         *
         * <pre>
         *  pre:  a null node
         *  post: a node with some object for its data and
         *        a pointer to a next node
         * </pre>
         *
         * @param datum
         *            an object for the node's data
         * @param next
         *            the node that this node points to
         */
        public Node(Object datum, Node<T> next)
        {
            myData = datum;
            myNext = next;
        }

        // Accessor methods
        public void setData(Object datum)
        {
            myData = datum;
        }

        public Object getData()
        {
            return myData;
        }

        public void setNext(Node<T> next)
        {
            myNext = next;
        }

        public Node<T> getNext()
        {
            return myNext;
        }

    }

}
