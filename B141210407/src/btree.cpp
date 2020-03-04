/**
* @file btree.cpp
* @description İkili arama ağacı kaynak dosyası
* @course 1C
* @assignment 3
* @date 14/12/2019
* @author Emine Çetiner emine.cetiner@ogr.sakarya.edu.tr
*/
#include <iostream>
#include "btree.hpp"
using namespace std;

btree::btree(){
    root = NULL;
}

btree::~btree(){
    destroy_tree();
}

void btree::destroy_tree(node *leafNode){
    if(leafNode != NULL){
        destroy_tree(leafNode->left);
        destroy_tree(leafNode->right);
        delete leafNode;
    }
}

void btree::insert(int key, node *leafNode){

    if(key <= leafNode->value){
        if(leafNode->left != NULL){
            insert(key, leafNode->left);
        }else{
            leafNode->left = new node;
            leafNode->left->value = key;
            leafNode->left->left = NULL;
            leafNode->left->right = NULL;
        }
    }else if(key > leafNode->value){
        if(leafNode->right != NULL){
            insert(key, leafNode->right);
        }else{
            leafNode->right = new node;
            leafNode->right->value = key;
            leafNode->right->right = NULL;
            leafNode->right->left = NULL;
        }
    }

}

void btree::insert(int key){
    if(root != NULL){
        insert(key, root);
    }else{
        root = new node;
        root->value = key;
        root->left = NULL;
        root->right = NULL;
    }
}


node *btree::deletenode(int key){
    return deleteNode(key, root);
}

void btree::destroy_tree(){
    destroy_tree(root);
}


void btree::SoyCounter(){
    if(root != NULL)
    {
       SoySayisiTemizle(root);
       SoyCounter(root);  
    }
}

node* btree::SoyCounter(node *leafNode){
    if(leafNode==root)
    {
        root->toplam_soy_sayisi=0;
        root->max_value=0;
        SoyCounter(leafNode,leafNode);
        root->toplam_soy_sayisi+=leafNode->soy_sayisi;
        if(leafNode->value > root->max_value)
        {
            root->max_value=leafNode->value;
        }
    }
    if(leafNode != NULL)
    {
        if(leafNode->left!=NULL)
        {
            SoyCounter(leafNode->left,leafNode->left);
            SoyCounter(leafNode->left);
            root->toplam_soy_sayisi+=leafNode->left->soy_sayisi;
            if(leafNode->left->value > root->max_value)
            {
                root->max_value=leafNode->left->value;
            }
        }

        if(leafNode->right!=NULL)
        {
            SoyCounter(leafNode->right,leafNode->right);
            SoyCounter(leafNode->right);
            root->toplam_soy_sayisi+=leafNode->right->soy_sayisi;
            if(leafNode->right->value > root->max_value)
            {
                root->max_value=leafNode->right->value;
            }
        }
    }
}

node* btree::SoyCounter(node *leafNode, node *rootleafNode){
    if(leafNode != NULL)
    {
        rootleafNode->soy_sayisi++;
        if(leafNode->left!=NULL)
        {
            SoyCounter(leafNode->left,rootleafNode);
        }

        if(leafNode->right!=NULL)
        {
            SoyCounter(leafNode->right,rootleafNode);
        }
    }
}
int btree::ToplamSoySayisi()
{
    return root->toplam_soy_sayisi;
}

int btree::MaxValue()
{
    return root->max_value;
}

node* btree::findMax(node *currentNode)
{
    if(currentNode->right==NULL)
        return currentNode;

    return findMax(currentNode->right);
}   

node* btree::deleteNode(int value,node *currentNode)
{
    if(currentNode==NULL) 
        return NULL;
    else if(value < currentNode->value) 
        currentNode->left = deleteNode(value,currentNode->left);
    else if(value > currentNode->value) 
        currentNode->right = deleteNode(value,currentNode->right);
    else 
    {
        if(currentNode->left == NULL && currentNode->right == NULL)
        {
            currentNode = NULL;
        }
        else if(currentNode->left == NULL) 
        {
            currentNode = currentNode->right;
        }
        else if(currentNode->right == NULL) 
        {
            currentNode = currentNode->left;
        }
        else 
        {
            node *tempNode = findMax(currentNode->left);
            currentNode->value = tempNode->value;
            currentNode->left = deleteNode(tempNode->value,currentNode->left);
        }

    }

    return currentNode;
}

void btree::Postorder()
{
    Postorder(root);
}

void btree::Postorder(node* leafNode)
{
    if(leafNode != NULL)
    {
        Postorder(leafNode->left);
        Postorder(leafNode->right);              
        cout<<"("<<leafNode->value<<","<<leafNode->soy_sayisi<<") ";
    }
}

int btree::KokGetir()
{
    return root->value;
}


void btree::SoySayisiTemizle(node* leafNode)
{
    if(leafNode != NULL)
    {
        SoySayisiTemizle(leafNode->left);
        SoySayisiTemizle(leafNode->right); 
        leafNode->soy_sayisi=-1;
    }
}