import java.io.File
import kotlin.system.exitProcess

fun main() {
    val parentDirectory = File(System.getProperty("user.dir"))
    val files = parentDirectory.listFiles()
    if(files.isNullOrEmpty()) exitProcess(666)
    deleteFilesInFolderIfWax(files)
}
fun deleteFilesInFolderIfWax(files:Array<File>) {
    if(files.isNullOrEmpty()) return
    for (file in files) {
        if(file.isFile) {if(!(file.extension.equals("mp3", ignoreCase = true)||file.extension.equals("jpg", ignoreCase = true))) file.delete()} else if(file.isDirectory) {deleteFilesInFolderIfWax(file)} else continue
    }
}
fun deleteFilesInFolderIfWax(folder:File) {
    val files = folder.listFiles()
    if(files.isNullOrEmpty()) return
    for (file in files) {
        if(file.isFile) {if(!(file.extension.equals("mp3", ignoreCase = true)||file.extension.equals("jpg", ignoreCase = true))) file.delete()} else if(file.isDirectory) {deleteFilesInFolderIfWax(file)} else continue
    }
}