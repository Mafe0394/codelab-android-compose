package com.codelabs.state.domain

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.codelabs.state.data.WellnessTask

class WellnessViewModel: ViewModel() {
    private val _tasks = getWellnessTaskList().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    private fun getWellnessTaskList(): List<WellnessTask> = List(31) { WellnessTask(it, "Task # $it") }

    fun removeTask(task:WellnessTask) {
        _tasks.remove(task)
    }

    fun changeTaskChecked(task:WellnessTask) {
        _tasks.find{it.id == task.id}?.let {
            it.checked = !task.checked
        }
    }
}
