package subtask1

class HappyArray {

    fun main(args: Array<String>){
        val sadArray = intArrayOf(1, 2, 2, 9, 93, 2, 6, 9, 6, 10)
        val happyArray = convertToHappy(sadArray)//1, 2, 7, 8, 9, 3)

        print(happyArray.contentToString())

        //val sadArray = intArrayOf()
        //val happyArray = intArrayOf(1, 2, 2, 2, 6, 9, 6, 10)
    }
    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {

        val newArray = mutableListOf<Int>()
        var isHappy  = checkIfHappy(sadArray)
        var arrayToIterate = sadArray

        while (!isHappy) {
            newArray.clear()
            for (id in arrayToIterate.indices) {
                if (!checkIfBad(arrayToIterate, id))
                    newArray.add(arrayToIterate[id])
            }
            arrayToIterate = newArray.toIntArray()
            isHappy = checkIfHappy(arrayToIterate)
        }
        return arrayToIterate
    }

    private fun checkIfBad(array: IntArray, index: Int): Boolean {
        if (index==0 || index == array.lastIndex)
            return false
        else
            return array[index - 1] + array[index + 1] < array[index]
    }

    private fun checkIfHappy(array: IntArray): Boolean{
        var isHappy = true
        for (id in array.indices) {
            if (checkIfBad(array, id))
                isHappy = false
        }
        return isHappy
    }

}


