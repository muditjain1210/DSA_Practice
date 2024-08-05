package binaarySearch;


class FindPeakElementTest {


    void findPeakElement() {
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement.findPeakElement(nums));

        int[] nums2 = {1, 2, 3, 1};
        System.out.println(findPeakElement.findPeakElement(nums2));

        int[] nums3 = {1};
        System.out.println(findPeakElement.findPeakElement(nums3));

        int[] nums4 = {1, 1, 2, 2};
        System.out.println(findPeakElement.findPeakElement(nums4));
    }
}