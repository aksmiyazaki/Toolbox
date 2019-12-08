package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.{Directory, File}
import com.rtjvm.scala.oop.filesystem.State

import scala.annotation.tailrec

class Echo(args : Array[String]) extends Command {

  def createContent(args: Array[String], topIndex: Int): String = {
    @tailrec def createContentHelper(curIdx: Int, accumulator: String): String = {
      if(curIdx >= topIndex) accumulator
      else createContentHelper(curIdx + 1, s"$accumulator ${args(curIdx)}")
    }

    createContentHelper(0, "")
  }

  def getRootAfterEcho(curDirectory: Directory, path: List[String], contents: String, append: Boolean): Directory = {
    if (path.isEmpty) curDirectory
    else if (path.tail.isEmpty) {
      val dirEntry = curDirectory.findEntry(path.head)
      if(dirEntry == null)
        curDirectory.addEntry((new File(curDirectory.path, path.head, contents)))
      else if (dirEntry.isDirectory) curDirectory
      else
        if (append) curDirectory.replaceEntry(path.head, dirEntry.asFile.appendContents(contents))
        else curDirectory.replaceEntry(path.head, dirEntry.asFile.setContents(contents))
    } else {
      val nextDirectory = curDirectory.findEntry(path.head).asDirectory
      val newNextDirectory = getRootAfterEcho(nextDirectory, path.tail, contents, append)

      if(nextDirectory == newNextDirectory) curDirectory
      else curDirectory.replaceEntry(path.head, newNextDirectory)
    }
  }

  def doEcho(state: State, contents: String, filename: String, append: Boolean): State = {
    if (filename.contains(Directory.SEPARATOR))
      state.setMessage("Echo: filename must not contain separators")
    else {

      val newRoot: Directory = getRootAfterEcho(state.root, state.wd.getAllFoldersInPath :+ filename, contents, append)
      if (newRoot == state.root)
        state.setMessage(s"$filename : no such file.")
      else
        State(newRoot, newRoot.findDescendant(state.wd.getAllFoldersInPath))
    }
  }

  override def apply(state: State): State = {
    if(args.isEmpty) state
    else if (args.length == 1) state.setMessage(args(0))
    else {
      val operator = args(args.length - 2)
      val filename = args(args.length - 1)
      val contents = createContent(args, args.length - 2)

      if(operator == ">>")
        doEcho(state, contents, filename, true)
      else if (operator == ">")
        doEcho(state, contents, filename, false)
      else
        state.setMessage(createContent(args, args.length))
    }
  }
}
