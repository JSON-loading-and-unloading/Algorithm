package week1;

import java.util.Scanner;

public class B_14500 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int column = sc.nextInt();
        int row = sc.nextInt();
        int board[][] = new int[column][row];

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int[] a = {0,2};
        int[] b = {2,1};
        int[] c = {1,0};
        int[] d = {0,0};
        int[] e = {0,0};
        int[] f = {0,0};
        int[] g = {0,1};
        int[] h = {1,2};
        int[] i = {2,0};
        int[] j = {0,0};
        int[] k = {1,0};
        int[] l = {2,0};
        int[] m = {1,2};
        int[] n = {0,0};
        int[] o = {0,0};
        int[] p = {0,1};
        int[] q = {0,0};
        int[] r = {1,0};
        int[] x = {0,0};

        int originRow = a[1];
        int max = 0;
        int sum;

        while (a[0] < column-1) {
            while (a[1] < row) {
                sum = board[a[0]][a[1]] + board[a[0]+1][a[1]] + board[a[0]+1][a[1]-1] + board[a[0]+1][a[1]-2];
                if (max < sum)
                    max = sum;
                a[1] += 1;
            }
            a[1] = originRow;
            a[0] += 1;
        }

        originRow = b[1];
        while (b[0] < column) {
            while (b[1] < row) {
                sum = board[b[0]][b[1]] + board[b[0]][b[1]-1] + board[b[0]-1][b[1]-1] + board[b[0]-2][b[1]-1];
                if (max < sum)
                    max = sum;
                b[1] += 1;
            }
            b[1] = originRow;
            b[0] += 1;
        }

        originRow = c[1];
        while (c[0] < column) {
            while (c[1] < row-2) {
                sum = board[c[0]][c[1]] + board[c[0]-1][c[1]] + board[c[0]-1][c[1]+1] + board[c[0]-1][c[1]+2];
                if (max < sum)
                    max = sum;
                c[1] += 1;
            }
            c[1] = originRow;
            c[0] += 1;
        }

        originRow = d[1];
        while (d[0] < column-2) {
            while (d[1] < row-1) {
                sum = board[d[0]][d[1]] + board[d[0]][d[1]+1] + board[d[0]+1][d[1]+1] + board[d[0]+2][d[1]+1];
                if (max < sum)
                    max = sum;
                d[1] += 1;
            }
            d[1] = originRow;
            d[0] += 1;
        }

        originRow = e[1];
        while (e[0] < column-1) {
            while (e[1] < row-1) {
                sum = board[e[0]][e[1]] + board[e[0]+1][e[1]] + board[e[0]+1][e[1]+1] + board[e[0]][e[1]+1];
                if (max < sum)
                    max = sum;
                e[1] += 1;
            }
            e[1] = originRow;
            e[0] += 1;
        }

        originRow = f[1];
        while (f[0] < column-1) {
            while (f[1] < row-2) {
                sum = board[f[0]][f[1]] + board[f[0]+1][f[1]] + board[f[0]+1][f[1]+1] + board[f[0]+1][f[1]+2];
                if (max < sum)
                    max = sum;
                f[1] += 1;
            }
            f[1] = originRow;
            f[0] += 1;
        }

        originRow = g[1];
        while (g[0] < column-2) {
            while (g[1] < row) {
                sum = board[g[0]][g[1]] + board[g[0]][g[1]-1] + board[g[0]+1][g[1]-1] + board[g[0]+2][g[1]-1];
                if (max < sum)
                    max = sum;
                g[1] += 1;
            }
            g[1] = originRow;
            g[0] += 1;
        }

        originRow = h[1];
        while (h[0] < column) {
            while (h[1] < row) {
                sum = board[h[0]][h[1]] + board[h[0]-1][h[1]] + board[h[0]-1][h[1]-1] + board[h[0]-1][h[1]-2];
                if (max < sum)
                    max = sum;
                h[1] += 1;
            }
            h[1] = originRow;
            h[0] += 1;
        }

        originRow = i[1];
        while (i[0] < column) {
            while (i[1] < row-1) {
                sum = board[i[0]][i[1]] + board[i[0]][i[1]+1] + board[i[0]-1][i[1]+1] + board[i[0]-2][i[1]+1];
                if (max < sum)
                    max = sum;
                i[1] += 1;
            }
            i[1] = originRow;
            i[0] += 1;
        }

        originRow = j[1];
        while (j[0] < column-2) {
            while (j[1] < row-1) {
                sum = board[j[0]][j[1]] + board[j[0]+1][j[1]] + board[j[0]+1][j[1]+1] + board[j[0]+2][j[1]+1];
                if (max < sum)
                    max = sum;
                j[1] += 1;
            }
            j[1] = originRow;
            j[0] += 1;
        }

        originRow = k[1];
        while (k[0] < column) {
            while (k[1] < row-2) {
                sum = board[k[0]][k[1]] + board[k[0]][k[1]+1] + board[k[0]-1][k[1]+1] + board[k[0]-1][k[1]+2];
                if (max < sum)
                    max = sum;
                k[1] += 1;
            }
            k[1] = originRow;
            k[0] += 1;
        }

        originRow = l[1];
        while (l[0] < column) {
            while (l[1] < row-1) {
                sum = board[l[0]][l[1]] + board[l[0]-1][l[1]] + board[l[0]-1][l[1]+1] + board[l[0]-2][l[1]+1];
                if (max < sum)
                    max = sum;
                l[1] += 1;
            }
            l[1] = originRow;
            l[0] += 1;
        }

        originRow = m[1];
        while (m[0] < column) {
            while (m[1] < row) {
                sum = board[m[0]][m[1]] + board[m[0]][m[1]-1] + board[m[0]-1][m[1]-1] + board[m[0]-1][m[1]-2];
                if (max < sum)
                    max = sum;
                m[1] += 1;
            }
            m[1] = originRow;
            m[0] += 1;
        }

        originRow = n[1];
        while (n[0] < column) {
            while (n[1] < row-3) {
                sum = board[n[0]][n[1]] + board[n[0]][n[1]+1] + board[n[0]][n[1]+2] + board[n[0]][n[1]+3];
                if (max < sum)
                    max = sum;
                n[1] += 1;
            }
            n[1] = originRow;
            n[0] += 1;
        }

        originRow = o[1];
        while (o[0] < column-1) {
            while (o[1] < row-2) {
                sum = board[o[0]][o[1]] + board[o[0]][o[1]+1] + board[o[0]+1][o[1]+1] + board[o[0]][o[1]+2];
                if (max < sum)
                    max = sum;
                o[1] += 1;
            }
            o[1] = originRow;
            o[0] += 1;
        }

        originRow = p[1];
        while (p[0] < column-2) {
            while (p[1] < row) {
                sum = board[p[0]][p[1]] + board[p[0]+1][p[1]] + board[p[0]+1][p[1]-1] + board[p[0]+2][p[1]];
                if (max < sum)
                    max = sum;
                p[1] += 1;
            }
            p[1] = originRow;
            p[0] += 1;
        }

        originRow = q[1];
        while (q[0] < column-2) {
            while (q[1] < row-1) {
                sum = board[q[0]][q[1]] + board[q[0]+1][q[1]] + board[q[0]+1][q[1]+1] + board[q[0]+2][q[1]];
                if (max < sum)
                    max = sum;
                q[1] += 1;
            }
            q[1] = originRow;
            q[0] += 1;
        }

        originRow = r[1];
        while (r[0] < column) {
            while (r[1] < row-2) {
                sum = board[r[0]][r[1]] + board[r[0]][r[1]+1] + board[r[0]-1][r[1]+1] + board[r[0]][r[1]+2];
                if (max < sum)
                    max = sum;
                r[1] += 1;
            }
            r[1] = originRow;
            r[0] += 1;
        }

        originRow = x[1];
        while (x[0] < column-3) {
            while (x[1] < row) {
                sum = board[x[0]][x[1]] + board[x[0]+1][x[1]] + board[x[0]+2][x[1]] + board[x[0]+3][x[1]];
                if (max < sum)
                    max = sum;
                x[1] += 1;
            }
            x[1] = originRow;
            x[0] += 1;
        }

        System.out.println(max);
    }
}
