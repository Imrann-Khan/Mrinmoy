package questions;

import doNotModify.Song;
import doNotModify.SongNode;

public class PlayQueue {
    public SongNode start; // DO NOT MODIFY
    public SongNode end;   // DO NOT MODIFY
    public int size;
    // You may add extra attributes here

    /**
     * Adds a Song to the end of the PlayQueue.
     * <p>
     * Note: This must be completed before moving onto any other method.
     * @param song - The Song to add
     */
    public void addSong(Song song) {
        /* TODO: To be completed*/
        SongNode curr = new SongNode(song, null, null);
        if (start == null) {
            start = curr;
            end = curr;
        } else {
            end.next = curr;
            curr.previous = end;
            end = curr;
        }

    }

    /**
     * Remove the first SongNode with the parameter Song from the PlayQueue.
     * <p>
     * Return true if a SongNode was removed, false otherwise.
     * @param song
     * @return - true if a SongNode was removed, false otherwise.
     */
    public boolean removeSong(Song song) {
        /* TODO: To be completed */ 
        SongNode curr = start;
        while(curr != null) {
            if (curr.song.equals(song)) {
                if (curr == start) {
                    start = curr.next;
                    start.previous = null;
                } else if (curr == end) {
                    end = curr.previous;
                    end.next = null;
                } else {
                    curr.previous.next = curr.next;
                    curr.next.previous = curr.previous;
                }
                return true;
            }
            curr = curr.next;
        }
        return false;  
    }

    /**
     * Removes the SongNode at the specified index from the PlayQueue, returning
     * the Song that was removed.
     * <p>
     * Return null if `index` is invalid.
     * @param index
     */
    public Song removeSong(int index) {
        int i = 0;
        SongNode curr = start;
        while (curr != null) {
            if (i == index) {
                if (curr == start) {
                    start = curr.next;
                    start.previous = null;
                } else if (curr == end) {
                    end = curr.previous;
                    end.next = null;
                } else {
                    curr.previous.next = curr.next;
                    curr.next.previous = curr.previous;
                }
                return curr.song;
            }
            curr = curr.next;
            i++;
        }
        return null;  
         /*TODO: To be completed */
    }

    /**
     * Return the size (number of SongNodes) in the PlayQueue.
     * @return the size of the PlayQueue
     */
    public int size() {
        int cnt = 0;
        SongNode curr = start;
        while (curr != null) {
            cnt++;
            curr = curr.next;
        }
        return cnt;  
        /*TODO: To be completed */
    }

    /**
     * Reverse the calling object PlayQueues Song ordering.
     */
    public void reverseQueue() {
        SongNode curr = start;
        SongNode temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = curr.previous;
            curr.previous = temp;
            curr = temp;
        }
         /*TODO: To be completed */
    }

    /**
     * Move the SongNode from the `fromIndex` index the specified `amount`.
     * 
     * Let the queue be:
     *       start              end
     *         |                 |
     * null <- a <-> b <-> c <-> d -> null
     * 
     * Let fromIndex be 1.
     * The expected queue should be as follows for:
     * amount := 0
     *       start              end
     *         |                 |
     * null <- a <-> b <-> c <-> d -> null
     * 
     * amount := 1
     *       start              end
     *         |                 |
     * null <- a <-> c <-> b <-> d -> null
     * 
     * amount := -1
     *       start              end
     *         |                 |
     * null <- b <-> a <-> c <-> d -> null
     * 
     * amount := 2
     *       start              end
     *         |                 |
     * null <- a <-> c <-> d <-> b -> null
     * <p>
     * Do nothing if either `fromIndex` is invalid, or `amount` is invalid for
     * the given `fromIndex`.
     * <p>
     * Do not create any new SongNode instances.
     * @param fromIndex
     * @param amount
     */
    public void moveSong(int fromIndex, int amount) {
        int i = 0;
        SongNode curr = start;
        SongNode from = null;
        while (curr != null) {
            if (i == fromIndex) {
                from = curr;
                break;
            }
            curr = curr.next;
            i++;
        }
        if (from == null) {
            return;
        }
        if (amount == 0) {
            return;
        }
        if (amount > 0) {
            for (int j = 0; j < amount; j++) {
                if (from.next == null) {
                    return;
                }
                if (from == start) {
                    start = from.next;
                    start.previous = null;
                } else {
                    from.previous.next = from.next;
                    from.next.previous = from.previous;
                }
                from.next.previous = from;
                from.previous = from.next;
                from.next = from.next.next;
                from.previous.next = from;
            }
        } else {
            for (int j = 0; j < -amount; j++) {
                if (from.previous == null) {
                    return;
                }
                if (from == start) {
                    start = from.previous;
                    start.next = null;
                } else {
                    from.previous.next = from.next;
                    from.next.previous = from.previous;
                }
                from.previous = from.previous.previous;
                from.next = from.previous;
                from.previous.next = from;
                from.next.previous = from;
            }
        }
         /*TODO: To be completed */
    }

    /**
     * Swap the SongNodes at parameter indices.
     * Do nothing if either parameters are invalid.
     * @param firstIndex
     * @param secondIndex
     */
    public void swapSongs(int firstIndex, int secondIndex) {
        int i = 0;
        SongNode first = null;
        SongNode second = null;
        SongNode curr = start;
        while (curr != null) {
            if (i == firstIndex) {
                first = curr;
            }
            if (i == secondIndex) {
                second = curr;
            }
            if (first != null && second != null) {
                Song temp = first.song;
                first.song = second.song;
                second.song = temp;
                break;
            }
            curr = curr.next;
            i++;
        }
         /*TODO: To be completed */
    }

    /**
     * Check the PlayQueue for cycles.
     * <p>
     * There is at most one cycle in the PlayQueue. This may be bi-directional.
     * @return - true if a cycle is detected, false otherwise.
     */
    public boolean hasCycle() {
        SongNode slow = start;
        SongNode fast = start;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;  
         /*TODO: To be completed */
    }

    /**
     * Create and return a (semi) randomly shuffled PlayQueue from the calling object.
     * <p>
     * A shuffled PlayQueue begins with the same Song as the calling object.
     * For all other Songs in the resulting PlayQueue the following formula is used:
     * <p>
     * (x^2 + 1) % p * s % n
     * <p>
     * where x is the index previously taken from,
     * <p>
     * where p is a prime number,
     * <p>
     * where s is seed number.
     * <p>
     * and n is the length of the PlayQueue
     * <p>
     * You must ensure that you do not go out of bounds, and that when the provided formula
     * creates a cycle that it is no longer used. Then the Songs in all uncovered SongNodes
     * are added in their original order to the resulting PlayQueue.
     * 
     * @param p - prime number
     * @param s - seed number
     * @return the shuffled queue
     */
    public PlayQueue shuffledQueue(int p, int s) {
        if (start == null) {
            return null;
        }
        PlayQueue shuffled = new PlayQueue();
        shuffled.addSong(start.song);
        SongNode curr = start.next;
        SongNode temp = shuffled.start;
        while (curr != null) {
            int index = ((temp.song.title.length()*temp.song.title.length() + 1) % p * s )% size;
            SongNode next = start;
            for (int i = 0; i < index; i++) {
                next = next.next;
            }
            if (next == curr) {
                break;
            }
            shuffled.addSong(next.song);
            temp = temp.next;
            curr = curr.next;
        }
        return shuffled; 
         /*TODO: To be completed */
    }


    @Override
    public String toString() {
        if (start == null) {
            return "null";
        }
        String forward = " forwards :         ";
        SongNode temp = start;
        while (temp.next != null) {
            forward += temp.song.title + " -> ";
            temp = temp.next;
        }
        forward += temp.song.title + " -> null";

        temp = end;
        String backward = "";
        while (temp.previous != null) {
            backward = " <- " + temp.song.title + backward;
            temp = temp.previous;
        }
        backward = "backwards : null <- " + temp.song.title + backward;
        return forward + "\n" + backward;
    }
}
