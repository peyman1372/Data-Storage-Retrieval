package datastorage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
//import java.util.TreeMap;
import java.util.TreeSet;

public class KMeans {
 int artnum;
	public KMeans(int artnum) throws IOException {
		// iterate k-means
		this.artnum=artnum;
		HashMap<String, TreeSet<Integer>> clusters = new HashMap<String, TreeSet<Integer>>();
		int dw=0;
		HashMap<String, TreeSet<Integer>> step = new HashMap<String, TreeSet<Integer>>();
		HashSet<Integer> rand = new HashSet<Integer>();
		LinkedHashMap<String, Double> res;
                File file = new File("TWords_Weight");
                file.mkdir();
	//	TreeMap<Double, HashMap<String, TreeSet<Integer>>> errorsums = new TreeMap<Double, HashMap<String, TreeSet<Integer>>>();
		int k = 100;
		int maxiter = 2;
		for (int init = 0; init < 1; init++) {
			clusters.clear();
			step.clear();
			rand.clear();
			
			// randomly initialize cluster centers
			while (rand.size() < k)
				rand.add((int) (Math.random() * artnum));
			// find vazn art r'th
			// vecspace: numart --> double[]
			// List<String> lines;
			// Charset charset = Charset.forName("ISO-8859-1");
			File f, temp;
			//copy weight vector to temp
			for (int r : rand) {
				f = new File("Words_Weight/Doc_Weight_" + (r) + ".txt");
				temp = new File("TWords_Weight/Doc_Weight_" + (r) + ".txt");
                                temp.createNewFile();
				// lines= Files.readAllLines(
				// Paths.get("Vectors/vector" + (r+1) + ".txt"), charset);
				// double[] temp = new double[lines.size()];
				copy(f, temp);
				// System.arraycopy(vecspace.get(r), 0, temp, 0, temp.length);
				step.put(temp.getName(), new TreeSet<Integer>());
			}
			System.out.println("yes");
			//System.exit(0);
			boolean go = true;
			int iter = 0;
			String s;
			while (go) {
				clusters = new HashMap<String, TreeSet<Integer>>(step);
				// cluster assignment step
				for (int i = 0; i < artnum; i++) {
//					System.out.println(i);
					s = "Words_Weight/Doc_Weight_" + (i) + ".txt";
					String cent = null;
					double sim = 0;
					// find max cluster that match with art i'th
					for (String c : clusters.keySet()) {
						double csim = cosSim(s, c);
//						 System.out.println(csim);
						if (csim >= sim) {
							sim = csim;
							cent = c;
						}
					}
					 System.out.println(cent);
					if (cent != null)
						clusters.get(cent).add(i);
				}
                                System.out.println("level 1 compelete");
				// centroid update step
				step.clear();
				//File cnt,
				File upc = null, v;
				for (String cent : clusters.keySet()) {
				//	cnt = new File("TVectors/" + cent);
					// upc=new File("Uectors/"+cent);
					// copy(cnt,upc);
					// double[] updatec = new double[cent.length];
					// weight cent
					Charset charset = Charset.forName("ISO-8859-1");
					List<String> lines = Files.readAllLines(
							Paths.get("TWords_Weight_/" + cent), charset);
					//cnt.delete();
					upc = new File("TWords_Weight/Doc_Weight_" + ("up" + dw)+".txt");
					FileWriter fwrite = new FileWriter(upc);
					BufferedWriter o = new BufferedWriter(fwrite);
					dw++;
					//System.out.println("***vector***" + (upc.getName()));
					res = new LinkedHashMap<String, Double>();
					int si = clusters.get(cent).size();
					for (int d : clusters.get(cent)) {
						// weight art d'th
						v = new File("Words_Weight/Doc_Weight_" + (d) + ".txt");
						// double[] doc = vecspace.get(d);
						FileReader fr1 = new FileReader(v);
						// FileReader fr2=new FileReader(cnt);
						BufferedReader bf1 = new BufferedReader(fr1);
						// BufferedReader bf2 = new BufferedReader (fr2);
						// double[cent.length];
						String b = new String();
						// String bb=new String();
						String[] b1, b2;
						b = bf1.readLine();
                                                HashMap<String,Double> tmpHash = new HashMap<String,Double>();
                                                while((b)!=null){
                                                    b1 = b.split(" ");
                                                    tmpHash.put(b1[0],Double.parseDouble(b1[1]));
                                                    b = bf1.readLine();
                                                }
						int g = 0;
						//for each member of cluster do
						while ((g < lines.size())) {
                                                    b2 = lines.get(g).split(" ");
                                                    if (tmpHash.containsKey(b2[0])) {
                                                            if (res.containsKey(b2[0]))
                                                                    res.put(b2[0],tmpHash.get(b2[0])+ Double.parseDouble(b2[1])+ res.get(b2[0]));
                                                            else
                                                                    res.put(b2[0], tmpHash.get(b2[0])+ Double.parseDouble(b2[1]));
                                                    }
                                                    g++;

						}
						bf1.close();
					}
					//calc average for cent and write new weight vector to TVectorFolder
					Double m;
					for (String x : res.keySet()) {
						m = res.get(x) / si;
						m = (Math.round(m * 100.0) / 100.0);
						// System.out.println(clusters.get(cent).size());
						if (m != 0)
							o.write(x + " " + m + "\n");
					}
					// for (int i = 0; i < updatec.length; i++)
					// updatec[i] += doc[i];
					// for (int i = 0; i < updatec.length; i++)
					// updatec[i] /= clusters.get(cent).size();
					// if(upc!=null)
					res.clear();
					o.close();
					System.out.println("name "+upc.getName());
					step.put(upc.getName(), new TreeSet<Integer>());
				}
				// check break conditions
				String oldcent = "", newcent = "";
				for (String x : clusters.keySet())
					oldcent += x;
				for (String x : step.keySet())
					newcent += x;
				if (oldcent.equals(newcent))
					go = false;
				if (++iter >= maxiter)
					go = false;
                                
                                System.out.println(iter + "   " + maxiter + "   " + oldcent + "   " + newcent);
                                
			}
			//*********************save clusters to file*******************************
			System.out.println(clusters.toString()
					.replaceAll("\\[[\\w@]+=", ""));
			for (String c : clusters.keySet()) {
				f = new File("Clusters/"+c);
                                f.createNewFile();
				FileWriter fwrite = new FileWriter(new File("Cluster/" + c));
				BufferedWriter o = new BufferedWriter(fwrite);
				o.write(clusters.get(c).toString()
						.replaceAll(" ","").replace(',', '\n')
						.replace("[", "").replace("]", ""));
				o.close();
			}
			if (iter < maxiter)
				System.out.println("Converged in " + iter + " steps.");
			else
				System.out.println("Stopped after " + maxiter + " iterations.");
			System.out.println("");

//			// calculate similarity sum and map it to the clustering
//			double sumsim = 0;
//			String st;
//			for (String c : clusters.keySet()) {
//				TreeSet<Integer> cl = clusters.get(c);
//				for (int vi : cl) {
//					st = "Tvectors/" + (vi + 1) + ".txt";
//					sumsim += cosSim("TVectors/" + c, st);
//				}
//			}
//			errorsums.put(sumsim, new HashMap<String, TreeSet<Integer>>(
//					clusters));

		}
		// pick the clustering with the maximum similarity sum and print the
		// filenames and indices
//		System.out.println("Best Convergence:");
//		System.out.println(errorsums.get(errorsums.lastKey()).toString()
//				.replaceAll("\\[[\\w@]+=", ""));
//		System.out.print("{");
//		for (String cent : errorsums.get(errorsums.lastKey()).keySet()) {
//			System.out.print("[");
//			for (int pts : errorsums.get(errorsums.lastKey()).get(cent)) {
//				System.out.print(pts + ", ");
//			}
//			System.out.print("\b\b], ");
//		}
//		System.out.println("\b\b}");
	}

	private double cosSim(String s, String c) {
		try {
			FileReader file1 = new FileReader(s);
			FileReader file2 = new FileReader("TWords_Weight/" + c);
			BufferedReader br1 = new BufferedReader(file1);
			BufferedReader br2 = new BufferedReader(file2);

			String b;
			String bb;
			String[] b1, b2;
			double dotp = 0, maga = 0, magb = 0;
                        HashMap<String,Double> tmpHash = new HashMap<String,Double>();
                        
			b = br1.readLine();
                        while((b) != null){
                            b1 = b.split(" ");
                            tmpHash.put(b1[0], Double.parseDouble(b1[1]));
                            b = br1.readLine();
                        }
                        
			bb = br2.readLine();
			while ((bb) != null) {
                            b2 = bb.split(" ");
                            if(tmpHash.containsKey(b2[0])){
                                dotp += tmpHash.get(b2[0])
                                                * Double.parseDouble(b2[1]);
                                // System.err.println(dotp);
                                maga += Math.pow(tmpHash.get(b2[0]), 2);
                                magb += Math.pow(Double.parseDouble(b2[1]), 2);
                            }
                            bb = br2.readLine();
			}
			// System.out.println(maga+ " "+magb);
			file1.close();
			file2.close();
			maga = Math.sqrt(maga);
			magb = Math.sqrt(magb);
			double d = dotp / (maga * magb);
			return d == Double.NaN ? 0 : Math.round(d * 100.0) / 100.0;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;

	}

	// static double cosSim(double[] a, double[] b) {
	// double dotp = 0, maga = 0, magb = 0;
	// for (int i = 0; i < a.length; i++) {
	// dotp += a[i] * b[i];
	// maga += Math.pow(a[i], 2);
	// magb += Math.pow(b[i], 2);
	// }
	// maga = Math.sqrt(maga);
	// magb = Math.sqrt(magb);
	// double d = dotp / (maga * magb);
	// return d == Double.NaN ? 0 : d;
	// }

	private static void copy(File source, File dest) throws IOException {
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		try {
//			System.out.println("yes");
			inputChannel = new FileInputStream(source).getChannel();
			outputChannel = new FileOutputStream(dest).getChannel();
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		} finally {
			inputChannel.close();
			outputChannel.close();
		}
	}

}
