package Adapters

import Models.Category
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ilhomjon.customtabitemsandcicrleindicatorintablayout.CategoryFragment

class CategoryAdapter(val categoryList:ArrayList<Category>, fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager,
BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getCount(): Int {
       return categoryList.size
    }

    override fun getItem(position: Int): Fragment {
        return CategoryFragment.newInstance(categoryList[position].imageList)
    }

//    override fun getPageTitle(position: Int): CharSequence? {
//        return categoryList[position].title
//    }
}