class ListNode {
    int val;
    ListNode next;

    // Default constructor
    ListNode() {}

    // Constructor to initialize with a value
    ListNode(int val) {
        this.val = val;
    }

    // Constructor to initialize with value and next node
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Deserialize method to convert array-like input into a ListNode
    public static ListNode deserialize(String input) {
        // Remove square brackets and split the string by commas
        input = input.replace("[", "").replace("]", "").trim();

        // Handle empty input
        if (input.isEmpty()) return null;

        // Split the input string into an array of integers
        String[] parts = input.split(",");
        ListNode dummy = new ListNode();  // Create a dummy node to start the linked list
        ListNode current = dummy;

        for (String part : parts) {
            // Parse each part as an integer and create a new node
            current.next = new ListNode(Integer.parseInt(part.trim()));
            current = current.next;
        }

        // Return the head of the linked list (skipping the dummy node)
        return dummy.next;
    }

    // Helper method to print the linked list for debugging
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}

public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to act as the starting point of the merged list
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining part of whichever list is not empty
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the merged list, starting from the node after dummy
        return dummy.next;
    }

    public static void main(String[] args) {
        // Test case input strings (as expected by the deserialization function)
        String list1String = "[1,2,4]";
        String list2String = "[1,3,4]";

        // Convert input strings to ListNode objects using deserialize method
        ListNode list1 = ListNode.deserialize(list1String);
        ListNode list2 = ListNode.deserialize(list2String);

        // Merge the two lists
        Merge_Two_Sorted_Lists solution = new Merge_Two_Sorted_Lists();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // Print the result
        ListNode.printList(mergedList);
    }
}
