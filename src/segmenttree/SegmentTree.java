package segmenttree;

public class SegmentTree {

    // Construct Segment Tree
    static int CST(int ss, int se, int si, int arr[], int tree[]) {
        if (ss == se) {
            tree[si] = arr[ss];
            return arr[ss];
        }

        int mid = (ss + se) / 2;

        tree[si] =
                CST(ss, mid, 2 * si + 1, arr, tree) +
                        CST(mid + 1, se, 2 * si + 2, arr, tree);

        return tree[si];
    }

    // Update utility
    static void updateRec(int ss, int se, int i, int si, int diff, int tree[]) {
        // index out of range
        if (i < ss || i > se)
            return;

        // update current node
        tree[si] = tree[si] + diff;

        // if not leaf, recur
        if (ss != se) {
            int mid = (ss + se) / 2;

            updateRec(ss, mid, i, 2 * si + 1, diff, tree);
            updateRec(mid + 1, se, i, 2 * si + 2, diff, tree);
        }
    }

    // Public update function
    static void update(int arr[], int tree[], int n, int i, int newVal) {
        int diff = newVal - arr[i];
        arr[i] = newVal;

        updateRec(0, n - 1, i, 0, diff, tree);
    }
    static int getSumRec(int qs, int qe, int ss, int se, int si, int tree[]) {
        if (se < qs || ss > qe)
            return 0;
        if (qs <= ss && qe >= se)
            return tree[si];

        int mid = (ss + se) / 2;

        return getSumRec(qs, qe, ss, mid, 2 * si + 1, tree)
                + getSumRec(qs, qe, mid + 1, se, 2 * si + 2, tree);

    }
        public static void main(String[] args) {

        int arr[] = {10, 20, 30, 40};
        int n = arr.length;

        int tree[] = new int[4 * n];

        // Build
        CST(0, n - 1, 0, arr, tree);

        System.out.println("Before update:");
        for (int x : tree) System.out.print(x + " ");

        int[][] queries = {
                {1, 3},
                {0, 2},
                {2, 3}
        };

        for (int i = 0; i < queries.length; i++) {
            int qs = queries[i][0], qe = queries[i][1];
            int sum = getSumRec(qs, qe, 0, n - 1, 0, tree);
            System.out.println("Sum of index " + qs + " to " + qe + " is " + sum);
        }
        // Update arr[1] = 25
        update(arr, tree, n, 1, 25);

        // Update arr[2] = 50
        update(arr, tree, n, 2, 50);
        for (int i = 0; i < queries.length; i++) {
            int qs = queries[i][0], qe = queries[i][1];
            int sum = getSumRec(qs, qe, 0, n - 1, 0, tree);
            System.out.println("Sum of index " + qs + " to " + qe + " is " + sum);
        }

        System.out.println("\nAfter update:");
        for (int x : tree) System.out.print(x + " ");
    }
}
