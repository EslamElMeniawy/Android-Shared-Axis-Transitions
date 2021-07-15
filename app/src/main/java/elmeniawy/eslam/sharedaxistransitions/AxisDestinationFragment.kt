package elmeniawy.eslam.sharedaxistransitions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialSharedAxis
import elmeniawy.eslam.sharedaxistransitions.databinding.FragmentAxisDestinationBinding

class AxisDestinationFragment : Fragment() {
    private var _binding: FragmentAxisDestinationBinding? = null
    private val _args: AxisDestinationFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup transition.
        enterTransition = MaterialSharedAxis(_args.axis, true)
        returnTransition = MaterialSharedAxis(_args.axis, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment.
        _binding = FragmentAxisDestinationBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup layout.
        _binding?.root?.setInsetsPadding(topBottomView = _binding?.layoutRoot)

        // Add title passed from args to XML.
        _binding?.tvTitle?.text = _args.title
    }
}