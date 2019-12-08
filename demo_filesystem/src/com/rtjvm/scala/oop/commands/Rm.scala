package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.Directory
import com.rtjvm.scala.oop.filesystem.State

class Rm(name: String) extends Command {

  def doRm(state: State, path: String): State = {
    def rmHelper(curDirectory: Directory, path: List[String]):Directory = {
      if (path.isEmpty) curDirectory
      else if (path.tail.isEmpty) curDirectory.removeEntry(path.head)
      else {
        val nextDirectory = curDirectory.findEntry(path.head)
        if(!nextDirectory.isDirectory) curDirectory
        else{
          val newNextDirectory = rmHelper(nextDirectory.asDirectory, path.tail)
          if(newNextDirectory == nextDirectory) curDirectory
          else curDirectory.replaceEntry(path.head, newNextDirectory)
        }
      }
    }

    // 4. find the entry to remove
    // 5. update structure (like on mkdir)
    val tokens = path.substring(1).split(Directory.SEPARATOR).toList
    val newRoot:Directory = rmHelper(state.root, tokens)
    if (newRoot == state.root) state.setMessage(s"$path no such file or directory")
    else State(newRoot, newRoot.findDescendant(state.wd.path.substring(1)))


  }

  override def apply(state: State): State = {
    // 1. get wd
    val wd = state.wd

    // 2. get abs path
    val absPath =
      if(name.startsWith(Directory.SEPARATOR)) name
      else if (wd.isRoot) wd.path + name
      else s"${wd.path}${Directory.SEPARATOR}$name"

    // 3. do some checks
    if (Directory.ROOT_PATH.equals((absPath)))
      state.setMessage(("Nuclear war not supported yet."))
    else
      doRm(state, absPath)
  }
}
