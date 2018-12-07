package offerOfSword;

/**
 * @authod xianCan
 * @date 2018/12/6 16:37
 *
 * 题目描述：
 *     请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Offer57 {
    private int index = -1;
    public String Serialize(TreeNode root){
        StringBuffer sb = new StringBuffer();
        SerializeTree(root,sb);
        return sb.toString();
    }

    private void SerializeTree(TreeNode root, StringBuffer sb){
        //如果节点为空，用#号表示
        if (root==null){
            sb.append("#,");
            return;
        }
        sb.append(root.value+",");
        SerializeTree(root.left,sb);
        SerializeTree(root.right,sb);
    }

    public TreeNode Deserialize(String str){
        index++;
        int len = str.length();
        if (index >= len)
            return null;
        String[] strings = str.split(",");
        TreeNode node = null;
        if (!strings[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}

