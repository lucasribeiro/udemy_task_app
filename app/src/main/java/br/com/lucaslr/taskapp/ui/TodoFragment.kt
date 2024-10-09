package br.com.lucaslr.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lucaslr.taskapp.R
import br.com.lucaslr.taskapp.data.model.Status
import br.com.lucaslr.taskapp.data.model.Task
import br.com.lucaslr.taskapp.databinding.FragmentTodoBinding
import br.com.lucaslr.taskapp.ui.adapter.TaskAdapter
import br.com.lucaslr.taskapp.ui.adapter.TaskTopAdapter

class TodoFragment : Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter
    private lateinit var taskTopAdapter: TaskTopAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()

        initRecyclerView()

        getTasks()
    }

    private fun initListeners() {
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_formTaskFragment)
        }
    }

    private fun initRecyclerView() {
        taskTopAdapter = TaskTopAdapter(requireContext()) { task, action ->
            optionSelected(task, action)
        }

        taskAdapter = TaskAdapter(requireContext() ) { task, action ->
            optionSelected(task, action)
        }

        val contactAdapter = ConcatAdapter(taskTopAdapter, taskAdapter)

        with(binding.rvTasks) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = contactAdapter
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

            TaskAdapter.SELECT_NEXT -> {
                Toast.makeText(requireContext(), "Next task ${task.description}", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun getTasks() {

        val taskList = listOf(
            Task("1", "Task 1 - TODO", Status.TODO),
            Task("2", "Task 2", Status.TODO),
            Task("3", "Task 3", Status.TODO),
            Task("4", "Task 4", Status.TODO),
            Task("5", "Task 5", Status.TODO),
            Task("6", "Task 6", Status.TODO),
            Task("7", "Task 7", Status.TODO),
            Task("8", "Task 8", Status.TODO),
            Task("9", "Task 9", Status.TODO),
            Task("10", "Task 10", Status.TODO)
        )

        val taskTopList = listOf(
            Task("0", "Task 0 - TOP TASKS", Status.TODO),
        )

        taskTopAdapter.submitList(taskTopList)
        taskAdapter.submitList(taskList)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}