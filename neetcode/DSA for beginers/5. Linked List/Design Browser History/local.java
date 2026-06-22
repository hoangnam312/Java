// Design Browser History

// You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

// Implement the BrowserHistory class:

// BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
// void visit(string url) Visits url from the current page. It clears up all the forward history.
// string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
// string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.

class Main {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        browserHistory.printHistory();
        System.out.println(browserHistory.back(1)); // facebook.com
        browserHistory.printHistory();
        System.out.println(browserHistory.back(1)); // google.com
        browserHistory.printHistory();
        System.out.println(browserHistory.forward(1)); // facebook.com
        browserHistory.printHistory();

        browserHistory.visit("linkedin.com");
        browserHistory.printHistory();

        System.out.println(browserHistory.forward(2)); // linkedin.com
        browserHistory.printHistory();
        System.out.println(browserHistory.back(2)); // google.com
        browserHistory.printHistory();
        System.out.println(browserHistory.back(7)); // leetcode.com
        browserHistory.printHistory();
    }
}

class BrowserHistory {

    private class Node {
        String url;
        Node prev;
        Node next;

        Node(String url) {
            this.url = url;
        }
    }

    private Node current;
    private Node head;

    public BrowserHistory(String homepage) {
        Node value = new Node(homepage);
        value.prev = null;
        value.next = null;
        current = value;
        head = value;
    }

    public void visit(String url) {
        Node value = new Node(url);
        current.next = value;
        value.prev = current;
        current = value;
    }

    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (current.prev == null)
                return current.url;
            current = current.prev;
        }
        return current.url;
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (current.next == null)
                return current.url;
            current = current.next;
        }
        return current.url;
    }

    public void printHistory() {
        Node pointer = head;

        while (pointer != null) {
            if (pointer == current) {
                System.out.print("[" + pointer.url + "]");
            } else {
                System.out.print(pointer.url);
            }

            if (pointer.next != null) {
                System.out.print(" -> ");
            }

            pointer = pointer.next;
        }

        System.out.println();
    }
}
