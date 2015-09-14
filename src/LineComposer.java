import java.awt.Point;

public class LineComposer implements ShapeComposer {

	@Override
	public AbstractShape create(Point startPos) {
		Line line = new Line(); // Create the shape - Line
		line.setStart(startPos);// Set the start position where mouse went down
		return line;
	}

	@Override
	public void expand(Point p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void complete(AbstractShape shape, Point endPos) {
		shape.setEnd(endPos);
	}

}
