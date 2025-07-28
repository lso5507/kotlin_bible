package basic





/** DECOMPILE
 * public final void process(@Nullable String str) {
 *    if (str != null) {
 *       boolean var4 = false;
 *       /*Do something*/
 *    }
 * }
 */
// NOT RECOMMENDED
fun process(str: String?) {
    str?.let { /*Do something*/   }
}
// RECOMMENDED
fun process_(str: String?) {
    if (str != null) {
        // Do Something
    }
}

class AClass(var title:String?){

}
// NOT RECOMMENDED
fun run사용(aClass: AClass?){
    aClass?.let{
        it.title="TEST"
    }
}
// RECOMMENDED
fun run사용_(aClass: AClass?){
    aClass?.run{
        title="TEST"
    }
}
// NOT RECOMMENDED
fun also사용(stringList:List<String>){
    stringList?.let{
        println("total : ${it.size}")
        it
    }?.forEach { println(it) }
}
// RECOMMENDED
fun also사용_(stringList:List<String>){
    stringList?.also{
        println("total : ${it.size}")
    }?.forEach { println(it) }
}
// NOT RECOMMENDED
fun chaining(str:String?): List<Char>?{
    return str?.toList()?.distinct()?.sorted()
}
// RECOMMENDED
fun chaining_(str: String?):List<Char>?{
    return str?.let { it.toList().distinct().sorted() }
}
