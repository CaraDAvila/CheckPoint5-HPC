package arvores;

public class AbbInt {
/*
Alterar essa classe para que armazena objetos da classe Cliente
 */
    private class No {
        int dado;
        No esq, dir;
    }

    public No root = null;

    public No inserir(No p, int info) {
        if (p == null) {
            p = new No();
            p.dado = info;
            p.esq = null;
            p.dir = null;
        } else if (info < p.dado) {
            p.esq = inserir(p.esq, info);
        } else {
            p.dir = inserir(p.dir, info);
        }
        return p;
    }

    public void mostrarEmOrdem(No p) {
        if (p != null) {
            mostrarEmOrdem(p.dir);
            System.out.print("\t" + p.dado);
            mostrarEmOrdem(p.esq);
        }
    }

    public int contaNos(No p, int cont) {
        if (p != null) {
            cont++;
            cont = contaNos(p.esq, cont);
            cont = contaNos(p.dir, cont);
        }
        return cont;
    }

    public boolean consulta(No p, int valor) {
        if (p != null) {
            if (valor == p.dado) {
                return true;
            } else if (valor < p.dado) {
                return consulta(p.esq, valor);
            } else {
                return consulta(p.dir, valor);
            }
        } else {
            return false;
        }
    }

    public int contaConsulta(No p, int valor, int cont) {
        if (p != null) {
            cont++;
            if (valor == p.dado) {
                return cont;
            }
            if (valor < p.dado) {
                return contaConsulta(p.esq, valor, cont);
            } else {
                return contaConsulta(p.dir, valor, cont);
            }
        }
        return cont;
    }

    public No removeValor(No p, int info) {
        if (p != null) {
            if (info == p.dado) {
                if (p.esq == null && p.dir == null)
                    return null;
                if (p.esq == null) {
                    return p.dir;
                } else {
                    if (p.dir == null) {
                        return p.esq;
                    } else {
                        No aux, ref;
                        ref = p.dir;
                        aux = p.dir;
                        while (aux.esq != null)
                            aux = aux.esq;
                        aux.esq = p.esq;
                        return ref;
                    }
                }
            } else {
                if (info < p.dado)
                    p.esq = removeValor(p.esq, info);
                else
                    p.dir = removeValor(p.dir, info);
            }
        }
        return p;
    }
    public Integer maximo(){
        No aux = root;
        if (aux != null) {
            while (aux.dir != null) {
                aux = aux.dir;
            }
            return aux.dado;
        }
        else{
            return null;
        }
    }

}