import mongoose, { Schema } from "mongoose";

const blogSchema = new Schema({
    title: {
        type: String,
    },
    description: {
        type: String,
    },
});

export const Blog = mongoose.model("Blog", blogSchema);
