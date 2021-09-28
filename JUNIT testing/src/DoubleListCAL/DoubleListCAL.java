package DoubleListCAL;

public class DoubleListCAL{
    private DoubleNode first;
    private DoubleNode last;
    private int nbNodes = 0;


    private boolean isEmpty() {
        return false;
    }

    private void checkPosition(int position){
        return;
    }

    private DoubleNode getNodeAtFromFirst(int position) throws IllegalArgumentException {
            return null;
        }

        private DoubleNode getNodeAtFromEnd(int position) throws IllegalArgumentException {
            return null;
        }


        private DoubleNode getNodeAt(int position) throws IllegalArgumentException {
            return null;
        }


        /**
         * @return the number of objects in the array
         */
        public int getNbElements() {
            return -1;
        }


        private DoubleNode getLastNode() {
            return null;
        }

        public Object getLastElement() {
            return null;
        }

        public Object getFirstElement() {
            return null;
        }


        /**
         * Insert the object o at the end of the list
         *
         * @param o
         * @throws IllegalArgumentException if o is null
         */
        public void insertLastElement(Object o) throws IllegalArgumentException {
            return;
        }

        /**
         * Insert the object o at the beginning of the list.
         *
         * @param o
         * @throws IllegalArgumentException if o is null
         */
        public void insertFirstElement(Object o) throws IllegalArgumentException {
            return;

        }


        /**
         * Insert the object o at the position "position".
         *
         * @param o
         * @throws IllegalArgumentException if o is null
         */
        public void insertElementAt(Object o, int position) throws IllegalArgumentException {
            return;
        }



        /**
         * @param position >0 && < getNbelements
         * @return object at position i
         * @throws IllegalArgumentException if the position n is not valide
         */
        public Object getElementAt(int position) throws IllegalArgumentException {
            return null;
        }


        /**
         * delete the object at position i
         *
         * @param position >0 && < getNbelements
         * @throws IllegalArgumentException if the position n is not valide
         */
        public void removeElementAt(int position) throws IllegalArgumentException {
            return;
        }


    /**
         * Remove the first occurrence of o from the list
         *
         * @param o non null
         * @return true if the item has been deleted, false else
         * @throws IllegalArgumentException if o is null
         */
        public boolean removeElement(Object o) throws IllegalArgumentException {
            return false;
        }

        /**
         * Remove all occurrences of o from the array
         *
         * @param o non null
         * @return the number of deleted elements
         * @throws IllegalArgumentException if o is null
         */
        public int removeAllOccurences(Object o) throws IllegalArgumentException {
            return -1;
        }


        public boolean removeFirstElement() throws IllegalArgumentException {
            return true;
        }

        public boolean removeLastElement() throws IllegalArgumentException {
            return true;
        }



        public String toString() {
            return "";
        }




    /**
     * list 1 2 3 4 5 6
     * list from start 1 2 3 4 5 6
     * list from end 6 5 4 3 2 1
     * check that the links are consistent in both directions
     * @return true if the scan from the end is the reverse of the scan from the start
     */
    public boolean checkIntegrity(){
        return true;
    }

    /**
     * QUESTION :
     * The checkIntegrity function is public, to be able to include it in the tests.
     * It is not a good practice.
     * 1/ Explain why the function should not be public (5pts)
     * ANSWER :
     *
     *
     *
     *
     * 2/ How could we use this function to guarantee the integrity of our links,
     * without impacting production performance. (5 pts)
     * ANSWER :
     *
     *
     *
     *
     * 3/ Keep public visibility, but try to integrate verification correctly
     * in your code (5pts)
     * ANSWER (briefly explain how you did it):
     *
     *
     *
     *
     *
     */


}
