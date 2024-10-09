package br.com.lucaslr.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lucaslr.taskapp.R
import br.com.lucaslr.taskapp.data.model.Status
import br.com.lucaslr.taskapp.data.model.Task
import br.com.lucaslr.taskapp.databinding.FragmentDoneBinding
import br.com.lucaslr.taskapp.ui.adapter.TaskAdapter

class DoneFragment : Fragment() {

    private var _binding: FragmentDoneBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDoneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        getTasks()
    }

    private fun initRecyclerView() {
//        taskTopAdapter = TaskTopAdapter(requireContext()) { task, action ->
//            optionSelected(task, action)
//        }

        taskAdapter = TaskAdapter(requireContext() ) { task, action ->
            optionSelected(task, action)
        }

        with(binding.rvTasks) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = taskAdapter
        }
    }

    private fun optionSelected(task: Task, option: Int) {
        when (option) {

            TaskAdapter.SELECT_REMOVE -> {
                Toast.makeText(requireContext(), "Remove task ${task.description}", Toast.LENGTH_SHORT).show()
            }

            TaskAdapter.SELECT_EDIT -> {
                Toast.makeText(requireContext(), "Edit task ${task.description}", Toast.LENGTH_SHORT).show()
            }

            TaskAdapter.SELECT_DETAILS -> {
                Toast.makeText(requireContext(), "Details task ${task.description}", Toast.LENGTH_SHORT).show()
            }

            TaskAdapter.SELECT_BACK -> {
                Toast.makeText(requireContext(), "Back task ${task.description}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getTasks() {

        val taskList = listOf(
            Task("1", "Task 1 - DONE", Status.DONE),
            Task("2", "Task 2", Status.DONE),
            Task("3", "Task 3", Status.DONE),
            Task("4", "Task 4", Status.DONE),
            Task("5", "Task 5", Status.DONE),
            Task("6", "Task 6", Status.DONE),
            Task("7", "Task 7", Status.DONE),
            Task("8", "Task 8", Status.DONE),
            Task("9", "Task 9", Status.DONE),
            Task("10", "Task 10", Status.DONE)
        )

        taskAdapter.submitList(taskList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}