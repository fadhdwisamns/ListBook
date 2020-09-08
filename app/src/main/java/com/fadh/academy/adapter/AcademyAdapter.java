package com.fadh.academy.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fadh.academy.DetailCourseActivity;
import com.fadh.academy.R;
import com.fadh.academy.data.CourseEntity;

import java.util.ArrayList;
import java.util.List;

public class AcademyAdapter extends RecyclerView.Adapter<AcademyAdapter.CourseViewHolder> {
    private List<CourseEntity> listCourse = new ArrayList<>();

    public void setCourse(List<CourseEntity> listCourse){
        if (listCourse == null) return;;
        listCourse.clear();
        listCourse.addAll(listCourse);
    }
    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_academy, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        CourseEntity course = listCourse.get(position);
        holder.bind(course);
    }

    @Override
    public int getItemCount() {
        return listCourse.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDescription;
        final TextView tvDate;
        final ImageView imgPoster;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            imgPoster = itemView.findViewById(R.id.img_poster);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvDate = itemView.findViewById(R.id.tv_item_date);
        }

        public void bind(CourseEntity course) {
            tvTitle.setText(course.getTitle());
            tvDescription.setText(course.getDescription());
            tvDate.setText(itemView.getResources().getString(R.string.deadline_date, course.getDeadline()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DetailCourseActivity.class);
                    intent.putExtra(DetailCourseActivity.EXTRA_COURSE, course.getCourseid());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
