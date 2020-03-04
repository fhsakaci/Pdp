/**
* @file btree.hpp
* @description İkili arama ağacı kaynak dosyası
* @course 1C
* @assignment 3
* @date 14/12/2019
* @author Emine Çetiner emine.cetiner@ogr.sakarya.edu.tr
*/
#ifndef BINARYTREE_HPP
#define BINARYTREE_HPP

struct node{
    int value;
    int soy_sayisi=-1;
    int toplam_soy_sayisi=0;
    int max_value=0;
    node *left;
    node *right;
};

class btree{
public:
    btree();
    ~btree();

    void insert(int key);
    node *deletenode(int key);
    void destroy_tree();
    void inorder_print();
    void postorder_print();
    void SoyCounter();
    int  ToplamSoySayisi();
    int  MaxValue();
    void Postorder();
    int  KokGetir();
    void SoySayisiTemizle(node* leafNode);

private:
    node * deleteNode(int value,node *currentNode);
	void Postorder(node* leafNode);
	node * findMax(node *currentNode);
    void destroy_tree(node *leafNode);
    void sil(node *leafNode);
    void insert(int key, node *leafNode);
    node *SoyCounter(node *leafNode);
    node *SoyCounter(node *leafNode,node *rootleafNode);
    node *root;
};


#endif