package lederer;
public class Dictionary {
	
	private class TreeNode {
		String word;
		TreeNode left;
		TreeNode right;

		public TreeNode(String word) {
			this.word = word;
			left = null;
			right = null;
		}
	}

	private TreeNode root;

	public Dictionary() {
		root = null;
	}

	public void insertWordNode(String word) {
		root = insert(root, word);
	}

	public void checkWord(String word) {
		root = delete(root, word);
	}

	private TreeNode insert(TreeNode root, String word) {
		if (root == null) {
			return new TreeNode(word);
		}

		int compare = word.compareTo(root.word);
		if (compare < 0) {
			root.left = insert(root.left, word);
		} else if (compare > 0) {
			root.right = insert(root.right, word);
		}

		return root;
	}

	private TreeNode delete(TreeNode root, String word) {
		if (root == null) {
			return root;
		}

		int compare = word.compareTo(root.word);
		if (compare < 0) {
			root.left = delete(root.left, word);
		} else if (compare > 0) {
			root.right = delete(root.right, word);
		} else {
			// Node to delete found with one or no child
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			// Node to delete found with two children
			root.word = minValue(root.right);
			root.right = delete(root.right, root.word);
		}

		return root;
	}

	private String minValue(TreeNode root) {
		String minValue = root.word;
		while (root.left != null) {
			minValue = root.left.word;
			root = root.left;
		}
		return minValue;
	}
	private TreeNode findNode(TreeNode root, String word) {
	    if (root == null || root.word.equals(word)) {
	        return root;
	    }

	    int compare = word.compareTo(root.word);
	    if (compare < 0) {
	        return findNode(root.left, word);
	    } else {
	        return findNode(root.right, word);
	    }
	}

	public boolean spellCheck(String word) {
        return findNode(root, word) != null;
    }
}
