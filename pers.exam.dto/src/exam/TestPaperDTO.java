package exam;

import java.io.Serializable;
import java.util.List;

/**
 * @author xxyWi
 * 试卷传输类
 */
public class TestPaperDTO implements Serializable {

    private Integer id;
    private String paperTitle;
    private List<TestPaperItem> items;

    public TestPaperDTO(Integer id, String paperTitle, List<TestPaperItem> items) {
        this.id = id;
        this.paperTitle = paperTitle;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public List<TestPaperItem> getItems() {
        return items;
    }

    public void setItems(List<TestPaperItem> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return "TestPaperDTO{" +
                "paperTitle='" + paperTitle + '\'' +
                ", items=" + items +
                '}';
    }

    public static class TestPaperItem implements Serializable {
        private String title;
        private List<SelectItem> items;

        public TestPaperItem(String title, String answer, List<SelectItem> items) {
            this.title = title;
            this.items = items;
            this.answer = answer;
        }

        private String answer;


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<SelectItem> getItems() {
            return items;
        }

        public void setItems(List<SelectItem> items) {
            this.items = items;
        }


        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public static class SelectItem implements Serializable {
            private String Option;

            public SelectItem(String option, String content) {
                Option = option;
                Content = content;
            }

            private String Content;

            public String getOption() {
                return Option;
            }

            public void setOption(String option) {
                this.Option = option;
            }

            public String getContent() {
                return Content;
            }

            public void setContent(String content) {
                Content = content;
            }
        }
    }
}
