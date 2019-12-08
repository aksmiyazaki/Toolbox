package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.{DirEntry, Directory}
import com.rtjvm.scala.oop.filesystem.State

import scala.annotation.tailrec

class Cd(dir: String) extends Command {
  override def apply(state: State): State = {
    // 1. find root
    val root = state.root
    val wd = state.wd

    // 2. find absolute path of the directory I want to cd to
    val absPath =
      if(dir.startsWith(Directory.SEPARATOR)) dir
      else if(wd.isRoot) wd.path + dir
      else wd.path + Directory.SEPARATOR + dir

    // 3. find the directory to cd to, given the path
    val destDirectory = doFindEntry(root, absPath)

    // 4. change the state given the new directory
    if(destDirectory == null || !destDirectory.isDirectory)
      state.setMessage(s"$dir no such directory")
    else
      State(root, destDirectory.asDirectory)

  }

  def doFindEntry(root: Directory, path: String): DirEntry = {
    @tailrec
    def findEntryHelper(curDirectory: Directory, path: List[String]): DirEntry =
      if(path.isEmpty || path.head.isEmpty) curDirectory
      else if(path.tail.isEmpty) curDirectory.findEntry(path.head)
      else {
        val nextDir = curDirectory.findEntry(path.head)
        if(nextDir == null || !nextDir.isDirectory) null
        else findEntryHelper(nextDir.asDirectory, path.tail)
      }

    @tailrec
    def collapseRelativeTokens(path: List[String], result: List[String]): List[String] = {
      if (path.isEmpty) result
      else if (".".equals(path.head)) collapseRelativeTokens(path.tail, result)
      else if ("..".equals(path.head)) {
        if(result.isEmpty) null
        else collapseRelativeTokens(path.tail, result.init)
      } else collapseRelativeTokens(path.tail, result :+ path.head)
    }


    val tokens: List[String] = path.substring(1).split(Directory.SEPARATOR).toList

    val newTokens = collapseRelativeTokens(tokens, List())

    if (newTokens == null) null
    else findEntryHelper(root, newTokens)
  }
}
