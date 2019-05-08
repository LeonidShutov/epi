package search;

public class T121 {
	private static int searchFirst(int[] ar, int i) {
		int left=0;
		int right=ar.length;
		while (left<=right){
			int mid=(left+right)/2;
			if (ar[mid]<i){
				left=mid+1;
			} else if (ar[mid]>i){
				right=mid-1;
			}else {
				int t=0;
				while (ar[mid-t]==i){
					t++;
				}
				return mid-t+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] ar={-14,-10,2,108,108,243,285,285,285,401};
		System.out.println(searchFirst(ar,108));
		System.out.println(searchFirst(ar,285));
	}
}
