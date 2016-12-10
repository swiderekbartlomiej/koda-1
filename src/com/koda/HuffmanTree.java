package com.koda;

import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanTree<NodeType extends HuffmanTreeNode> 
{

	ArrayList<HuffmanTreeNode> m_Tree;
	
	
	public HuffmanTree(HashMap<NodeType, Long> alphabet) 
	{
		int tree_size = (int)Math.floor((Math.log(alphabet.size())/Math.log(2.0))); //Max elements in binary tree
		m_Tree = new ArrayList<HuffmanTreeNode>(tree_size);
	}
}
