#include <iostream>
#include <vector>
#include <queue>
#include <time.h>

#define inf 100
#define ii pair <int, int>
#define suc priority_queue<ii, vector<ii>, greater<ii> >
#define Digraph vector<suc >

using namespace std;

Digraph adList;

void nearAux(int start, int pD, vector<bool> *pb, int *suma)
{
    suc actualQueue = adList[pD];
    ii actual = adList[pD].top();
    int aux = inf;
    int auxW = inf;
    char a;

    while((!actualQueue.empty()) && (*pb)[actual.second])
    {
        ii proff = actualQueue.top();
        actualQueue.pop();
        actual = actualQueue.top();
        if(actual.second == start)
        {
            aux = actual.second;
            auxW = actual.first;
        }
    }

    if(actualQueue.empty())
    {
        if(aux == start)
        {
            *suma+= auxW;
        }
    }
    else
    {
        (*pb)[actual.second] = true;
        *suma+= actual.first;
        nearAux(start,actual.second,pb,suma);
    }
}

void visitados(vector<bool> *r)
{
    for(int i = 0; i < r->size(); ++i)
    {
        cout << (*r)[i] << endl;
    }
}

int near()
{
    vector<bool> r(adList.size(),false);
    vector<bool> *p = &r;
    Digraph *g = &adList;
    int pD = 0;
    int sum = 0;
    int *suma = &sum;
    (*p)[0] = true;
    nearAux(0,0, p, suma);
    return sum;
}

void imprimirGrafo(Digraph p)
{
    //Imprimiendo grafo
    for(int x = 0; x < p.size(); ++x)
    {
        cout << x << ": ";
        int c = p[x].size();
        for(int j = 0; j <c; ++j)
        {
            cout << "["<< p[x].top().first << "," << p[x].top().second << "] ";
            p[x].pop();
        }
        cout << endl;
    }
}

int main()
{

    //Redefiniendo el tamaño del grafo
    adList.resize(4);

    //Llenando grafo (pesos primero y luego vertice)
    adList[0].push(make_pair(6,3));
    adList[0].push(make_pair(7,1));
    adList[0].push(make_pair(15,2));
    adList[1].push(make_pair(2,0));
    adList[1].push(make_pair(7,2));
    adList[1].push(make_pair(3,3));
    adList[2].push(make_pair(9,0));
    adList[2].push(make_pair(6,1));
    adList[2].push(make_pair(12,3));
    adList[3].push(make_pair(10,0));
    adList[3].push(make_pair(4,1));
    adList[3].push(make_pair(8,2));
    Digraph p(adList);
    //imprimirGrafo(p);
    cout << "Costo minimo: " << near() << endl;

    return 0;
}
