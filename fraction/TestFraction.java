/*
 * TestFraction.java
 * 
 * Copyright 2018 Rahul P V <u4cse17256@10CPU0076L>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import java.util.Scanner;



public class TestFraction {
	 public static float determinant(float matrix[][])
       { float sign=1;
		 float det=0;
		   
		 for(int j=0;j<3;j++)
			 {det+=matrix[0][j]*sign*(cofact(matrix,0,j));
					
	          sign=sign*-1;		
			}
			return det;
	   }
	   
	public  static  float cofact(	float matrix[][],int p,int q)
	 { float co[][]= new float[2][2];
	   float cof;
	   int a=0,b=0;
		for(int i=0;i<3;i++)
			{for(int j=0;j<3;j++)
				{if(	(i!=p)&&(j!=q))
					{co[a][b]=matrix[i][j];
						b++;
						if(b==2)
						{a++;
							b=0;
						}
					}
				}
			}
			return cof=(co[0][0]*co[1][1])-(co[0][1]*co[1][0]);
		}
			
	
	
    public static void main(String[] args) {
        
        Scanner scan = new Scanner("8/3 4/9 5/7 6/3 5/7 6/2 2/3 8/9 5/4");

        
        Fraction fractions[][] = new Fraction[3][3];

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                fractions[i][j] = new Fraction(scan.next());
            }
        }

			float ans = Value(fractions);

			System.out.println("determinant equals "+ans);
			scan.close();
    }

    public static float Value(Fraction[][] fractions) {
        float ans = 0;
        float matrix[][]=new float[3][3];
        for(int i=0;i<3;i++)
			{for(int j=0;j<3;j++)
				{matrix[i][j]=fractions[i][j].getValue();
					System.out.println(matrix[i][j]);
			 }
			}
		 ans=determinant(matrix);
        return ans;
    }
}


