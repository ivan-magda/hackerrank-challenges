fun main(args: Array<String>) {
    val beverages = Node("beverages")

    val hotBeverages = Node("hot")
    val coldBeverages = Node("cold")

    beverages.add(hotBeverages)
    beverages.add(coldBeverages)

    println(beverages)

    println(beverages.search("cold")) // returns the "cold" node
    println(beverages.search("hot")) // returns the "hot" node
    println(beverages.search("bubbly")) // returns nil
}
