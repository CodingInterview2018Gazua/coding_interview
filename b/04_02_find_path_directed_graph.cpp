/* 4.2 Given a directed graph, design an algorithm to find out where there is a route between two nodes. */

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Graph
{
  public:
    Graph(int _n) : n(_n + 1)
    {
        adj = new vector<int>[n];
    }
    void addEdge(int u, int v)
    {
        adj[u].push_back(v);
    }
    bool hasRoute(int u, int v)
    {
        queue<int> qu;
        queue<int> qv;
        int visited[n];
        for (auto &&it : visited)
        {
            it = -1;
        }
        qu.push(u);
        qv.push(v);
        visited[u] = u;
        visited[v] = v;
        cout << u << "->" << endl;
        cout << v << "->" << endl;

        while (!qu.empty())
        {
            auto bfs = [](int s, int d, int visited[], queue<int> &q, vector<int> *adj) -> bool {
                int t = q.front();
                q.pop();
                for (auto &&it : adj[t])
                {
                    if (visited[it] == -1)
                    {
                        cout << t << ".. "
                             << "->" << it << endl;
                        visited[it] = s;
                        q.push(it);
                    }
                    else if (visited[it] == d)
                    {
                        cout << t << ".. "
                             << "->" << it << endl;
                        cout << "found" << endl;
                        return true;
                    }
                }
                cout << "turn:" << t << endl;
                return false;
            };
            if (bfs(u, v, visited, qu, adj) == true)
                return true;
            if (bfs(v, u, visited, qv, adj) == true)
                return true;
        }
        return false;
    }

  private:
    vector<int> *adj;
    int n;
};

void test()
{
    Graph g(8);
    g.addEdge(1, 2);
    g.addEdge(1, 3);
    g.addEdge(1, 4);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
    g.addEdge(3, 5);
    g.addEdge(4, 3);
    g.addEdge(5, 3);
    g.addEdge(5, 6);
    g.addEdge(5, 8);
    g.addEdge(6, 7);
    g.addEdge(8, 7);
    g.addEdge(7, 5);

    cout << g.hasRoute(1, 7) << endl;
}

int main()
{
    test();
    return 0;
}
